package com.example.party_planner.controller;


import com.example.party_planner.dto.EventDto;
import com.example.party_planner.service.EventService;
import com.example.party_planner.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<String> CreateEvent(@RequestHeader(name = "Authorization", required = true) String customHeader,@RequestBody EventDto event) {
        eventService.createEvent(event);
        return ResponseEntity.ok().body("event created.");
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return ResponseEntity.ok(eventService.findAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findEventById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Long id, @RequestBody EventDto eventDto) {
        eventDto.setId(id);
        return ResponseEntity.ok(eventService.updateEvent(eventDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<EventDto>> searchEvents(@RequestParam(required = false) String location,
                                                       @RequestParam(required = false) String type,
                                                       @RequestParam(required = false) Boolean isPaid) {
        return ResponseEntity.ok(eventService.searchEvents(location, type, isPaid));

    }
}