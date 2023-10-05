package com.project.insert.domain.image.domain;

import com.project.insert.domain.post.domain.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imageName;

    @Column
    private String url;

    @Column
    private String imageExtension;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Image(MultipartFile validateFile, Post post){
        this.imageName = validateFile.getOriginalFilename();
        this.url = "http://localhost:8080/api/images/" + post.getId() + "_" + this.imageName;
        this.imageExtension = this.imageName.substring(this.imageName.lastIndexOf(".") + 1);
        this.post = post;
    }

}
