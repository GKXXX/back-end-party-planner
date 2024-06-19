package com.example.party_planner.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private UserDto author;
    private EventDto event;
}

