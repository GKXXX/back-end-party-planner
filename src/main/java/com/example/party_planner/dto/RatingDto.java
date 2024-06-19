package com.example.party_planner.dto;

import lombok.Data;

@Data
public class RatingDto {
    private Long id;
    private int stars;
    private String review;
    private UserDto reviewer;
    private UserDto reviewee;
}
