package com.example.party_planner.controller;

import com.example.party_planner.dto.InterestDto;
import com.example.party_planner.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interests")
@RequiredArgsConstructor
public class InterestController {
    private final InterestService interestService;

    @GetMapping
    public ResponseEntity<List<InterestDto>> getAllInterests() {
        return ResponseEntity.ok(interestService.findAllInterests());
    }

}
