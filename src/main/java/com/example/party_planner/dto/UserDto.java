package com.example.party_planner.dto;

import com.example.party_planner.entity.Event;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String city;
    private int age;
    private List<InterestDto> interests = new ArrayList<>();
    private List<CommentDto> comments = new ArrayList<>();
    private List<RatingDto> ratings = new ArrayList<>();
    private List<EventDto> events = new ArrayList<>();
}