package com.namChul.board.controller;

import com.namChul.board.controller.form.BoardForm;
import com.namChul.board.sevice.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final MemberService memberService;

    @GetMapping("board/list")
    public String boardList() {
        log.info("board List Controller");
        return "board/boardList";
    }

    @GetMapping("board/write")
    public String boardWrite (Model model, Principal principal) {
        log.info("board/write Controller");
        String username = principal.getName();
        Long memberId = memberService.MemberSearchByUsername(username);
        model.addAttribute("memberId",memberId);
        return "board/boardWrite";
    }

    @PostMapping("board/write")
    public String boardInsert(BoardForm boardForm) {

    return "redirect:/board/boardList";
    }

}
