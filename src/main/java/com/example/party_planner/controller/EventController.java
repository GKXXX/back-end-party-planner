package com.example.party_planner.controller;


import com.example.party_planner.dto.EventDto;
import com.example.party_planner.entity.Event;
import com.example.party_planner.service.EventService;
import com.example.party_planner.service.JwtService;
import com.example.party_planner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<String> CreateEvent(@RequestHeader(name = "Authorization", required = true) String customHeader,@RequestBody EventDto event) {

        if (!Objects.equals(event.getOrganizer().getId(), Long.getLong(jwtService.getIdFromToken(customHeader.replace("Bearer ", ""))))){
            eventService.createEvent(event);
            return ResponseEntity.ok().body("event created.");
        } else {
            return ResponseEntity.ok().body("Wrong organizer submitted.");
        }
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
    public ResponseEntity<String> updateEvent(@RequestHeader(name = "Authorization", required = true) String customHeader,@PathVariable Long id, @RequestBody EventDto eventDto) {
        if (Objects.equals(Long.getLong(jwtService.getIdFromToken(customHeader.replace("Bearer ", ""))), eventDto.getOrganizer().getId())) {
            eventDto.setId(id);
            eventService.updateEvent(eventDto);
            return ResponseEntity.ok().body("Event modified.");
        } else {
            return ResponseEntity.ok().body("You are not authorized to modify this event.");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@RequestHeader(name = "Authorization", required = true) String customHeader,@PathVariable Long id) {
        EventDto event = eventService.findEventById(id);
        if (Objects.equals(Long.getLong(jwtService.getIdFromToken(customHeader.replace("Bearer ",""))),event.getOrganizer().getId())) {
            eventService.deleteEvent(id);
            return ResponseEntity.ok().body("Event deleted.");
        } else {
            return ResponseEntity.ok().body("You are not authorized to delete this event.");
        }

    }

    @PostMapping("/participate/{id}")
    public  ResponseEntity<String> participate(@RequestHeader(name = "Authorization", required = true) String customHeader,@PathVariable Long id) {
        Long idUser = Long.getLong(jwtService.getIdFromToken(customHeader.replace("Bearer ","")));
        EventDto event = eventService.findEventById(id);
        event.getParticipants().add(userService.findUserById(idUser));
        event.setAvailableSlots(event.getAvailableSlots() - 1);
        eventService.updateEvent(event);
        return ResponseEntity.ok().body("User successfully added to participants");
    }

    @GetMapping("/search")
    public ResponseEntity<List<EventDto>> searchEvents(@RequestParam(required = false) String location,
                                                       @RequestParam(required = false) Long id_interest,
                                                       @RequestParam(required = false) Boolean isPaid) {
        return ResponseEntity.ok(eventService.searchEvents(location, id_interest, isPaid));

    }

    @GetMapping("/searchByCity")
    public ResponseEntity<List<EventDto>> searchByCity(@RequestParam(required = true)String city) {
        return ResponseEntity.ok(eventService.)
    }
}