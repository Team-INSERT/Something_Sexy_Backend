package com.project.insert.domain.post.domain;

import com.project.insert.domain.category.domain.Category;
import com.project.insert.domain.post.presentation.dto.PostDto;
import com.project.insert.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="author")
    private User author;

    public Post(String title, String content, User author){
        this.title = title;
        this.content = content;
        localDate = LocalDate.now();
        this.author = author;
    }

    public void update(PostDto postDto){
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.category.setName(postDto.getCategory());
        localDate = LocalDate.now();
    }

}
