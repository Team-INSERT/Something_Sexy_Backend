package com.project.insert.domain.comment.service;

import com.project.insert.domain.comment.domain.Comment;
import com.project.insert.domain.comment.domain.repository.CommentRepository;
import com.project.insert.domain.comment.presentation.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentDto create(CommentDto commentDto) {
        Comment comment = new Comment(commentDto.getContent(),commentDto.getPostid(),commentDto.getAuthor()); // id null
        Comment save = commentRepository.save(comment); // id가 들어간 객체 반환
        return new CommentDto(save);
    }

    public List<CommentDto> findComment(Long id) {
        return commentRepository.findAllByPostid(id)
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }
    public CommentDto update(CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("No Comment exist"));
        comment.update(commentDto);
        commentRepository.save(comment);
        return new CommentDto(comment);
    }


    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}