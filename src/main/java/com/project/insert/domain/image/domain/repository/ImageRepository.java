package com.project.insert.domain.image.domain.repository;

import com.project.insert.domain.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByPostId(Long id);

    void deleteAllByPostId(Long id);
}
