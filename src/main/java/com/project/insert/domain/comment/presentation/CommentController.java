package com.project.insert.domain.comment.presentation;

import com.project.insert.domain.comment.presentation.dto.CommentDto;
import com.project.insert.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comment/")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("create")
    public CommentDto create(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @GetMapping("get/{blog_id}")
    public List<CommentDto> findComment(@PathVariable Long blog_id) {
        return commentService.findComment(blog_id);
    }

    @PutMapping("update/{id}")
    public CommentDto update(@PathVariable Long id,@RequestBody CommentDto commentDto) {
        commentDto.setId(id);
        return commentService.update(commentDto);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}