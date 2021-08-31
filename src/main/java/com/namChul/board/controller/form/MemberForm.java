package com.namChul.board.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "아이디를 입력해주세요.")
    private String username;
    @NotEmpty(message = "패스워드를 입력해주세요")
    private String password;
//    @NotEmpty(message = "이름을 입력해주세요")
    private String name;

    public MemberForm(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public MemberForm() {
    }
}
