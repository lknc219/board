package com.namChul.board.sevice;

import com.namChul.board.repository.BoardRepository;
import com.namChul.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

//    public Long BoardInsert () {
//
//    }
}
