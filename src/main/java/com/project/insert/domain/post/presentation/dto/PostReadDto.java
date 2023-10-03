package com.project.insert.domain.post.presentation.dto;

import com.project.insert.domain.category.domain.Category;
import com.project.insert.domain.image.presentation.dto.ImageFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostReadDto {

    private String title;
    private String content;
    private List<ImageFormat> imageList;
    private String category;

    public PostReadDto(String title, String content, Category category, List<ImageFormat> imageList){
        this.title = title;
        this.content = content;
        this.category = category.getName();
        this.imageList = imageList;
    }
}
