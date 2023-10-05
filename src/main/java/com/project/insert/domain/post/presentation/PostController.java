package com.project.insert.domain.post.presentation;

import com.project.insert.domain.post.service.PostService;
import com.project.insert.domain.post.presentation.dto.PostDto;
import com.project.insert.domain.post.presentation.dto.PostReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/api/read/all")
    public List<PostDto> readAll() {
        return postService.readAll();
    }

    @GetMapping("/api/read/{id}")
    public PostReadDto findOne(@PathVariable Long id){
        return postService.readOne(id);
    }

    @GetMapping("/api/read")
    public List<PostDto> readCategory(@RequestParam("category") String category){
        return postService.readCategory(category);
    }

    @PutMapping("/api/update")
    public void updatePost(@RequestPart("requestDto") PostDto postDto,
                           @RequestPart(value = "files", required = false) List<MultipartFile> files) throws IOException {
        postService.updatePost(postDto, files);
    }

    @DeleteMapping("/api/delete/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
