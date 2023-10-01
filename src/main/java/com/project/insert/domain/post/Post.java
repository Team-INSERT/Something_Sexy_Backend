package com.project.insert.domain.post;

import com.project.insert.presentation.post.dto.PostDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    @Column(name = "date")
    @LastModifiedDate
    private LocalDate localDate;

    public Post(String title, String content){
        this.title = title;
        this.content = content;
        localDate = LocalDate.now();
    }

    public void update(PostDto postDto){
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        localDate = LocalDate.now();
    }

}
