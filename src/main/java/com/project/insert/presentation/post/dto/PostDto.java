package com.project.insert.presentation.post.dto;

import com.project.insert.domain.post.Image;
import com.project.insert.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Long id;

    private String title;

    private String content;

    private LocalDate localDate;
    private String thumbnailUrl;


    public PostDto(Post post, Image thumbnailUrl){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.localDate = post.getLocalDate();
        this.thumbnailUrl = thumbnailUrl.getUrl();
    }
}
