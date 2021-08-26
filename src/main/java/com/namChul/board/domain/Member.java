package com.namChul.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String longinId;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private UseYn UesYn;

    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    public Member(String longinId, String password, String name) {
        this.longinId = longinId;
        this.password = password;
        this.name = name;
        this.UesYn = UseYn.Y;
        this.joinDate = LocalDateTime.now();
    }

    public Member() {
    }
}
