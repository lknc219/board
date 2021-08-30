package com.namChul.board.sevice;

import com.namChul.board.controller.form.MemberForm;
import com.namChul.board.domain.Member;
import com.namChul.board.domain.Role;
import com.namChul.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 회원가입
     *
     * @param form
     * @return id를 반환한다 save 실패시 -1
     */
    public Long memberSave(MemberForm form) {

        Optional<Member> findMember = memberRepository.findByUsername(form.getUsername());
        if (!findMember.isEmpty()){
            log.info("아이디 중복");
            throw new IllegalStateException("회원 아이디 중복");
        }

        Member member = new Member(form.getUsername(),passwordEncoder.encode(form.getPassword()),form.getName());
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }

    /**
     * 로그인 사용x 스프링 시큐리티에서 지원하는 설정을 완료함으로 로그인 세션 지원
     * @param form
     * @return
     */
    public boolean memberLogin(MemberForm form) {

        if (form.getUsername()==null) {
            //사실 화면단에서 걸러줘서 여기까지 안옴
            log.info("아이디 미입력");
            return false;
        }

        if (form.getPassword()==null) {
            log.info("비밀번호 미입력");
            return false;
        }

        Optional<Member> findMember = memberRepository.findByUsername(form.getUsername());

        if(findMember.isEmpty())
            return false;

        if (!passwordEncoder.matches(form.getPassword(),findMember.get().getPassword())){
            log.info("패스워드 미일치");
            return false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> userEntityWrapper = memberRepository.findByUsername(username);
        Member member = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("superAdmin").equals(username)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(member.getUsername(),member.getPassword(),authorities);
    }


}
