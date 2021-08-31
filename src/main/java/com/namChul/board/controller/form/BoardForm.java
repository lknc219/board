package com.namChul.board.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BoardForm {

    @NotEmpty
    private Long MemberId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
