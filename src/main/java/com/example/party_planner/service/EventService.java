package com.example.party_planner.service;

import com.example.party_planner.dto.EventDto;
import com.example.party_planner.entity.Event;
import com.example.party_planner.mapper.EventMapper;
import com.example.party_planner.mapper.UserMapper;
import com.example.party_planner.repository.EventRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private UserMapper userMapper;


    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        return eventMapper.toDto(eventRepository.save(event));
    }

    public Page<EventDto> findByCity(Pageable pageable,String city) {
        return eventRepository.findByLocation(city,pageable).map(eventMapper::toDto);
    }

    public List<EventDto> findAllEvents() {
        return eventMapper.toDtos(eventRepository.findAll());
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

    public Page<EventDto> searchEvents(Pageable pageable,String location, Long id_interest, Boolean isPaid) {
        if (location != null) {
            return eventRepository.findByLocation(location,pageable).map(eventMapper::toDto);
        } else if (id_interest != null) {
            return eventRepository.findByInterest(id_interest,pageable).map(eventMapper::toDto);
        } else if (isPaid != null) {
            return eventRepository.findByIsPaid(isPaid,pageable).map(eventMapper::toDto);
        } else {
            return eventRepository.findAll(pageable).map(eventMapper::toDto);
        }
    }
}
