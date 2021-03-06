package com.namChul.board.sevice;

import com.namChul.board.controller.form.MemberForm;
import com.namChul.board.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {

        //given
        MemberForm memberForm = new MemberForm("test1","test1","김남철");
        Long saveId = memberService.memberSave(memberForm);
        em.flush();

        //when
        assertThat(memberRepository.findByUsername(memberForm.getUsername())).isEqualTo(memberRepository.findById(saveId));

        //then

    }

    @Test
    public void 회원가입_중복아이디() throws Exception {

        //given
        MemberForm memberForm1 = new MemberForm("test1","test1","김남철");
        Long saveId1 = memberService.memberSave(memberForm1);
        MemberForm memberForm2 = new MemberForm("test1","test1","김남철");

        //when
//        assertThatThrownBy(() -> {memberService.memberSave(memberForm2)}).isInstanceOf(IllegalStateException.class);

        //then
    }

    @Test
    public void 로그인성공() throws Exception {

        //given
        MemberForm memberForm = new MemberForm("test1","test1","김남철");
        memberService.memberSave(memberForm);


        //when
        memberService.memberLogin(memberForm);

        //then

    }
}