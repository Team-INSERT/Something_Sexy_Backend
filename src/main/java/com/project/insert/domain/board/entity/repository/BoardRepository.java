package com.project.insert.domain.board.entity.repository;

import com.project.insert.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
