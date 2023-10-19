package com.project.insert.domain.comment.presentation.dto;

import com.project.insert.domain.comment.domain.Comment;
import com.project.insert.domain.comment.domain.Recomment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RecommentDto {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime date;
    private Long commentid;
    public RecommentDto(Recomment recomment){
        this.id=recomment.getId();
        this.content=recomment.getContent();
        this.author=recomment.getAuthor();
        this.date=recomment.getDate();
        this.commentid=recomment.getCommentid();
    }
    public void setId(Long id) {
        this.id = id;
    }
}
