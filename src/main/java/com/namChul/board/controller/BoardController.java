package com.namChul.board.controller;

import com.namChul.board.controller.form.BoardForm;
import com.namChul.board.domain.Board;
import com.namChul.board.sevice.BoardService;
import com.namChul.board.sevice.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final MemberService memberService;
    private final BoardService boardService;

    @GetMapping("board/list")
    public String boardList(Model model, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {

        PageRequest pageRequest = PageRequest.of(page,5);
        Page<Board> boards = boardService.BoardList(pageRequest);

        model.addAttribute("board",boards);

        return "board/boardList";
    }

    @GetMapping("board/write")
    public String boardWrite (Model model, Principal principal) {

        String username = principal.getName();
        Long memberId = memberService.MemberSearchByUsername(username);
        model.addAttribute("memberId",memberId);
        return "board/boardWrite";
    }

    @PostMapping("board/write")
    public String boardInsert(BoardForm boardForm) {
        boardService.BoardInsert(boardForm);
    return "redirect:/board/list";
    }

}
