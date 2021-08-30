package com.namChul.board.repository;

import com.namChul.board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
     Optional<Member> findByUsername(String username);
}
