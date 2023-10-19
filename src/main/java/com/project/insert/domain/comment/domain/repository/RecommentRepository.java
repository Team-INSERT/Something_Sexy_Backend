package com.project.insert.domain.comment.domain.repository;

import com.project.insert.domain.comment.domain.Comment;
import com.project.insert.domain.comment.domain.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommentRepository extends JpaRepository<Recomment,Long> {
    List<Recomment> findAllByCommentid(Long commentid);
}
