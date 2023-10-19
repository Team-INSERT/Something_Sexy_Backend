package com.project.insert.domain.comment.domain;

import com.project.insert.domain.comment.presentation.dto.CommentDto;
import com.project.insert.domain.comment.presentation.dto.RecommentDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recomment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recomment_id",nullable = false)
    private Long id;
    @Lob
    @Column(nullable = false)
    private String content;
    private String author;
    @LastModifiedDate
    private LocalDateTime date;
    private Long commentid;
    public Recomment(String content,Long commentid,String author){
        this.content=content;
        date=LocalDateTime.now();
        this.commentid=commentid;
        this.author=author;
    }
    public void update(RecommentDto recommentDto){
        this.content=recommentDto.getContent();
        date=LocalDateTime.now();
    }
}