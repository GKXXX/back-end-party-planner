package com.example.party_planner.mapper;

import com.example.party_planner.dto.UserDto;
import com.example.party_planner.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {InterestMapper.class, CommentMapper.class, EventMapper.class,RatingMapper.class})
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    List<UserDto> toDtos(List<User> users);
    List<User> toEntities(List<UserDto> userDtos);
}
