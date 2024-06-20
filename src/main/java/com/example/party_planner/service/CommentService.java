package com.example.party_planner.service;

import com.example.party_planner.dto.CommentDto;
import com.example.party_planner.entity.Comment;
import com.example.party_planner.mapper.CommentMapper;
import com.example.party_planner.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    public List<CommentDto> findAllComments() {
        return commentMapper.toDtos(commentRepository.findAll());
    }

    public CommentDto findCommentById(Long id) {
        return commentMapper.toDto(commentRepository.findById(id).orElse(null));
    }

    public CommentDto updateComment(CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
