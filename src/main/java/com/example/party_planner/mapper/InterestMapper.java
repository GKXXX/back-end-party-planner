package com.example.party_planner.mapper;

import com.example.party_planner.dto.InterestDto;
import com.example.party_planner.entity.Interest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface InterestMapper {
    InterestDto toDto(Interest interest);
    Interest toEntity(InterestDto interestDto);
    List<InterestDto> toDtos(List<Interest> interests);
    List<Interest> toEntities(List<InterestDto> interestDtos);
}

