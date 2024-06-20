package com.example.party_planner.mapper;

import com.example.party_planner.dto.EventDto;
import com.example.party_planner.entity.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class, InterestMapper.class})
public interface EventMapper {
    EventDto toDto(Event event);
    Event toEntity(EventDto eventDto);
    List<EventDto> toDtos(List<Event> events);
    List<Event> toEntities(List<EventDto> eventDtos);
}

