package com.example.party_planner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String city;
    private int age;
    private List<InterestDto> interests; // Assuming interests are stored as a list of strings
    private List<CommentDto> comments;
    private List<RatingDto> ratings;
    private List<EventDto> events;
}

