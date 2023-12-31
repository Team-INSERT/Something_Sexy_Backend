package com.project.insert.domain.category.domain.repository;

import com.project.insert.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
