package com.project.insert.domain.post.dto;

import com.project.insert.domain.image.dto.ImageFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostReadDto {

    private String title;
    private String content;
    private List<ImageFormat> imageList;

    public PostReadDto(String title, String content, List<ImageFormat> imageList){
        this.title = title;
        this.content = content;
        this.imageList = imageList;
    }
}
