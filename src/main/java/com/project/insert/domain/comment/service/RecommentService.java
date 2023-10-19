package com.project.insert.domain.comment.service;

import com.project.insert.domain.comment.domain.Comment;
import com.project.insert.domain.comment.domain.Recomment;
import com.project.insert.domain.comment.domain.repository.RecommentRepository;
import com.project.insert.domain.comment.presentation.dto.CommentDto;
import com.project.insert.domain.comment.presentation.dto.RecommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class RecommentService {
    private final RecommentRepository recommentRepository;

    public RecommentDto create(RecommentDto recommentDto) {
        Recomment recomment = new Recomment(recommentDto.getContent(),recommentDto.getCommentid(),recommentDto.getAuthor()); // id null
        Recomment save = recommentRepository.save(recomment); // id가 들어간 객체 반환
        return new RecommentDto(save);
    }

    public List<RecommentDto> findRecomment(Long id) {
        return recommentRepository.findAllByCommentid(id)
                .stream()
                .map(RecommentDto::new)
                .collect(Collectors.toList());
    }

    public RecommentDto update(RecommentDto recommentDto) {
        Recomment recomment = recommentRepository.findById(recommentDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("No Recomment exist"));
        recomment.update(recommentDto);
        recommentRepository.save(recomment);
        return new RecommentDto(recomment);
    }

    public void delete(Long id) {
        recommentRepository.deleteById(id);
    }
}