package com.namChul.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(indexes = @Index(name = "i_member", columnList = "username"))
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private UseYn UesYn;

    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.UesYn = UseYn.Y;
        this.joinDate = LocalDateTime.now();
    }

    public Member() {
    }
}
