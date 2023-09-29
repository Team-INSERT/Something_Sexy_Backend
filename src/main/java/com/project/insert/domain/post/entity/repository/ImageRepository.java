package com.project.insert.domain.post.entity.repository;

import com.project.insert.domain.post.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByPostId(Long id);

    void deleteByPostId(Long id);
}
