package com.project.insert.presentation.post.dto;

import com.project.insert.domain.post.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageFormat {

    private String imageName;
    private String imageExtension;
    private String url;

    public ImageFormat(Image image){
        this.imageName = image.getImageName();
        this.imageExtension = image.getImageExtension();
        this.url = image.getUrl();
    }
}
