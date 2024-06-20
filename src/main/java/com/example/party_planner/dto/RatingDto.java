package com.example.party_planner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Long id;
    private int stars;
    private String review;
    private UserDto reviewer;
    private UserDto reviewee;
}
