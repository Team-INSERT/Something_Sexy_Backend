package com.project.insert.presentation.post.dto;

import com.project.insert.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class PostDto {

    private Long id;

    private String title;

    private String content;

    private LocalDate localDate;

    public PostDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.localDate = post.getLocalDate();
    }
}
