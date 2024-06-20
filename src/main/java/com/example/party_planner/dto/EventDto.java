package com.example.party_planner.dto;

import com.example.party_planner.entity.Interest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    private String name;
    private String location;
    private LocalDateTime dateTime;
    private int availableSlots;
    private boolean isPaid;
    private double price;
    private Interest interest;
    private UserDto organizer;
    private List<UserDto> participants;
}
