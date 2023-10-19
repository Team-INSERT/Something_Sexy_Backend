package com.project.insert.domain.comment.domain;

import com.project.insert.domain.comment.presentation.dto.CommentDto;

import com.project.insert.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id",nullable = false)
    private Long id;
    @Lob
    @Column(nullable = false)
    private String content;
    private String author;
    @LastModifiedDate
    private LocalDateTime date;
    private Long postid;
    public Comment(String content,Long postid,String author){
        this.content=content;
        this.date=LocalDateTime.now();
        this.postid=postid;
        this.author=author;
    }
    public void update(CommentDto commentDto){
        this.content=commentDto.getContent();
        this.date=LocalDateTime.now();
    }
}
