package com.project.insert.domain.post.entity.repository;

import com.project.insert.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
