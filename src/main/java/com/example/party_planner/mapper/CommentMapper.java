package com.example.party_planner.mapper;

import com.example.party_planner.dto.CommentDto;
import com.example.party_planner.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(Comment comment);
    Comment toEntity(CommentDto commentDto);
    List<CommentDto> toDtos(List<Comment> comments);
    List<Comment> toEntities(List<CommentDto> commentDtos);
}

