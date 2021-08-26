package com.namChul.board.controller.form;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotNull
    private String loginId;
    @NotNull
    private String password;
    @NotNull
    private String name;

    public MemberForm(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }

    public MemberForm() {
    }
}
