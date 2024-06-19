package com.example.party_planner.mapper;

import com.example.party_planner.dto.RatingDto;
import com.example.party_planner.entity.Rating;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface RatingMapper {
    RatingDto toDto(Rating rating);
    Rating toEntity(RatingDto ratingDto);
    List<RatingDto> toDtos(List<Rating> ratings);
    List<Rating> toEntities(List<RatingDto> ratingDtos);
}
