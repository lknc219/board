package com.namChul.board.controller.form;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;

    public MemberForm(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public MemberForm() {
    }
}
