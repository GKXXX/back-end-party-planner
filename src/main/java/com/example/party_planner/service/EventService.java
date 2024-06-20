package com.example.party_planner.service;

import com.example.party_planner.dto.EventDto;
import com.example.party_planner.entity.Event;
import com.example.party_planner.mapper.EventMapper;
import com.example.party_planner.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        return eventMapper.toDto(eventRepository.save(event));
    }

    public List<EventDto> findByCity(String city) {
        return eventMapper.toDtos(eventRepository.findByLocation(city));
    }

    public List<EventDto> findAllEvents() {
        return eventMapper.toDtos(eventRepository.findAll());
    }

    public EventDto findEventById(Long id) {
        return eventMapper.toDto(eventRepository.findById(id).orElse(null));
    }

    public EventDto updateEvent(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        return eventMapper.toDto(eventRepository.save(event));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<EventDto> searchEvents(String location, Long id_interest, Boolean isPaid) {
        if (location != null) {
            return eventMapper.toDtos(eventRepository.findByLocation(location));
        } else if (id_interest != null) {
            return eventMapper.toDtos(eventRepository.findByInterest(id_interest));
        } else if (isPaid != null) {
            return eventMapper.toDtos(eventRepository.findByIsPaid(isPaid));
        } else {
            return eventMapper.toDtos(eventRepository.findAll());
        }
    }
}
