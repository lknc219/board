package com.namChul.board.controller;

import com.namChul.board.controller.form.MemberForm;
import com.namChul.board.sevice.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService ;

    @GetMapping("member/join")
    public String memberJoinPage() {
        log.info("member join page");
        return "/member/memberJoin";
    }

    @PostMapping("member/insert")
    public String memberInsert(@Validated MemberForm form, BindingResult result){

        log.info("회원가입 START");
        if(result.hasErrors()){
            log.info("result Error");
            return "/member/memberJoin";
        }
        Long memberId = memberService.memberSave(form);
        log.info("회원가입 END");

        return "/login/login";
    }

    @GetMapping("member/login")
    public String memberLoginPage() {
        return "/login/login";
    }


//    스프링 시큐리티에서 설정을 완료함으로써 로그인 기능 완성
//    @PostMapping("member/login")
//    public String memberLogin(MemberForm form) {
//        if(!memberService.memberLogin(form)){
//            log.info("로그인 실패");
//            return "/login/login";
//        }
//        log.info("로그인 성공");
//        return "home";
//    }

    @GetMapping("member/logout/result")
    public String memberLogout() {
        return "/login/logout";
    }

    @GetMapping("member/info")
    public String memberInfo() {
        return "/login/myinfo";
    }

    @GetMapping("member/admin")
    public String memberAdmin() {
        return "/admin/admin";
    }

}
