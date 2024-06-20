package com.example.party_planner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    private String name;
    private String location;
    private String type;
    private Date dateTime;
    private int availableSlots;
    private boolean isPaid;
    private double price;
    private UserDto organizer;
    private List<UserDto> participants;
    private List<CommentDto> comments;
}
