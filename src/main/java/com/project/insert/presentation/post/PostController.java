package com.project.insert.presentation.post;

import com.project.insert.domain.post.service.PostService;
import com.project.insert.presentation.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/api/create")
    public void createPost(@RequestPart("requestDto") PostDto postDto,
                           @RequestPart(value = "files", required = false) List<MultipartFile> files) throws IOException{
        postService.createPost(postDto, files);
    }
}
