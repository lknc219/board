package com.namChul.board.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardForm {

    private Long memberId;

    private String title;

    private String content;
}
