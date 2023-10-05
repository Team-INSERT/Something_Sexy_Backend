package com.project.insert.domain.post.presentation.dto;

import com.project.insert.domain.category.domain.Category;
import com.project.insert.domain.image.presentation.dto.ImageFormat;
import com.project.insert.domain.post.domain.Post;
import com.project.insert.domain.user.domain.User;
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
    private String author;

    public PostReadDto(Post post, List<ImageFormat> imageList){
        this.title = post.getTitle();;
        this.content = post.getContent();
        this.category = post.getCategory().getName();
        this.imageList = imageList;
        this.author = post.getAuthor().getNickname();
    }
}
