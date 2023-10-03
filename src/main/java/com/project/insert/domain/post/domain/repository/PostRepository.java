package com.project.insert.domain.post.domain.repository;

import com.project.insert.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
