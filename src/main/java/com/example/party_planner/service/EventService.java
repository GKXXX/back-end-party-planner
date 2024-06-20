package com.example.party_planner.service;

import com.example.party_planner.dto.EventDto;
import com.example.party_planner.entity.Event;
import com.example.party_planner.mapper.EventMapper;
import com.example.party_planner.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;

    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        return eventMapper.toDto(eventRepository.save(event));
    }

    public EventDto findEventById(Long id) {
        return eventMapper.toDto(eventRepository.findById(id).orElse(null));
    }

    public Page<EventDto> findAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable).map(eventMapper::toDto);
    }

    public Page<EventDto> findEventsByIsPaid(Boolean isPaid, Pageable pageable) {
        return eventRepository.findByIsPaid(isPaid, pageable).map(eventMapper::toDto);
    }

    public EventDto updateEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        return eventMapper.toDto(eventRepository.save(event));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
