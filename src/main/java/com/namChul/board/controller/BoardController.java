package com.namChul.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class BoardController {

    @GetMapping("board/list")
    public String boardList() {
        log.info("board List Controller");
        return "board/boardList";
    }

    @GetMapping("board/write")
    public String boardWrite() {
        log.info("board/write Controller");
        return "board/boardWrite";
    }

}
