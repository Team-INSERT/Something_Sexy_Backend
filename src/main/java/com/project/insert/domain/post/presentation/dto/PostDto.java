package com.project.insert.domain.post.presentation.dto;

import com.project.insert.domain.image.domain.Image;
import com.project.insert.domain.post.domain.Post;
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

    private String category;

    public PostDto(Post post, Image thumbnailUrl){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.localDate = post.getLocalDate();
        this.category = post.getCategory().getName();
        this.thumbnailUrl = thumbnailUrl.getUrl();
    }
}
