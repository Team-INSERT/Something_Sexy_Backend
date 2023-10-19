package com.project.insert.domain.comment.domain.repository;

import com.project.insert.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostid(Long postid);

}