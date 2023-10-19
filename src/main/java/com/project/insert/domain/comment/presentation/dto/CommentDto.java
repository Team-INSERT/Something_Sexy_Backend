package com.project.insert.domain.comment.presentation.dto;

import com.project.insert.domain.comment.domain.Comment;
import com.project.insert.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime date;
    private Long postid;
    public CommentDto(Comment comment){
        this.id=comment.getId();
        this.content=comment.getContent();
        this.author=comment.getAuthor();
        this.date=comment.getDate();
        this.postid=comment.getPostid();
    }
    public void setId(Long id) {
        this.id = id;
    }
}
