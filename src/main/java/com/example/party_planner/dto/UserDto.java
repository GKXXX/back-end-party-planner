package com.example.party_planner.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String password; // Consider using a more secure approach for password handling
    private String region;
    private String city;
    private int age;
    private List<InterestDto> interests; // Assuming interests are stored as a list of strings
    private List<CommentDto> comments;
    private List<RatingDto> ratings;
}

