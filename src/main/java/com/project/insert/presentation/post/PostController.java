package com.project.insert.presentation.post;

import com.project.insert.domain.post.Post;
import com.project.insert.domain.post.service.PostService;
import com.project.insert.presentation.post.dto.PostDto;
import com.project.insert.presentation.post.dto.PostReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/api/create")
    public void createPost(@RequestPart("requestDto") PostDto postDto,
                           @RequestPart(value = "files", required = false) List<MultipartFile> files) throws IOException{
        List<String> types = new ArrayList<>();
        types.add("thumbnail");
        types.add("normal");
        postService.createPost(postDto, files, types);
    }

    @GetMapping("/api/read/all")
    public List<PostDto> readAll() {
        return postService.readAll();
    }

    @GetMapping("/api/read/{id}")
    public PostReadDto findOne(@PathVariable Long id){
        return postService.readOne(id);
    }
}
