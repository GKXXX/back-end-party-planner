package com.example.party_planner.controller;

import com.example.party_planner.dto.InterestDto;
import com.example.party_planner.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interests")
@RequiredArgsConstructor
public class InterestController {
    private final InterestService interestService;

    @GetMapping
    public ResponseEntity<Page<InterestDto>> getAllInterests(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(interestService.findAllInterests(pageable));
    }

}
