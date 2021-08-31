package com.namChul.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Enumerated(EnumType.STRING)
    private UseYn DeleteYn;

    private LocalDateTime insertDate;

    private LocalDateTime updateDate;

    public Board(Member member, String title, String content) {
        this.member = member;
        member.getBoards().add(this);
        this.title = title;
        this.content = content;
    }

}
