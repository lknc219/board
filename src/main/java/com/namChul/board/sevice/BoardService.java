package com.namChul.board.sevice;

import com.namChul.board.controller.form.BoardForm;
import com.namChul.board.domain.Board;
import com.namChul.board.domain.Member;
import com.namChul.board.repository.BoardRepository;
import com.namChul.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    /**
     * 게시글 작성
     * @param boardForm
     * @return
     */
    public Long BoardInsert (BoardForm boardForm) {

        Member findMember = memberRepository.findById(boardForm.getMemberId()).get();
        Board board = new Board(findMember, boardForm.getTitle(), boardForm.getContent());
        Board saveBoard = boardRepository.save(board);

        return saveBoard.getId();
    }

    public Page<Board> BoardList(PageRequest pageRequest) {
        return boardRepository.findAll(pageRequest);

    }
}
