package com.project.insert.domain.comment.presentation;

import com.project.insert.domain.comment.presentation.dto.CommentDto;
import com.project.insert.domain.comment.presentation.dto.RecommentDto;
import com.project.insert.domain.comment.service.RecommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/recomment/")
@RequiredArgsConstructor
public class RecommentController {
    private final RecommentService recommentService;

    @PostMapping("create")
    public RecommentDto create(@RequestBody RecommentDto recommentDto) {
        return recommentService.create(recommentDto);
    }

    @GetMapping("get/{comment_id}")
    public List<RecommentDto> findRecomment(@PathVariable Long comment_id) {
        return recommentService.findRecomment(comment_id);
    }

    @PutMapping("update/{id}")
    public RecommentDto update(@PathVariable Long id,@RequestBody RecommentDto recommentDto) {
        recommentDto.setId(id);
        return recommentService.update(recommentDto);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        recommentService.delete(id);
    }
}