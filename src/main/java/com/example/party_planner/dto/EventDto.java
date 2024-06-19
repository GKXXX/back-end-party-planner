package com.example.party_planner.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EventDto {
    private Long id;
    private String name;
    private String location;
    private String type;
    private Date date;
    private int availableSpots;
    private boolean isPaid;
    private double price;
    private UserDto organizer;
    private List<UserDto> participants;
    private List<CommentDto> comments;
}
