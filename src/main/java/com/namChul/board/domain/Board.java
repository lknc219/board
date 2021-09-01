package com.namChul.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter @Setter
@SequenceGenerator(
        name="BOARD_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="BOARD_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class Board {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BOARD_SEQ_GEN"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Enumerated(EnumType.STRING)
    private UseYn DeleteYn = UseYn.N;

    private String insertDate;

    private String updateDate;

    public Board(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.insertDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        member.getBoards().add(this);
    }

    public Board() {

    }
}
