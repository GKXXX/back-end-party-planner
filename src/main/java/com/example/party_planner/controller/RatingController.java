package com.example.party_planner.controller;

import com.example.party_planner.dto.RatingDto;
import com.example.party_planner.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.party_planner.dto.RatingDto;
import com.example.party_planner.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.createRating(ratingDto));
    }

    @GetMapping
    public ResponseEntity<Page<RatingDto>> getAllRatings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ratingService.findAllRatings(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable Long id) {
        return ResponseEntity.ok(ratingService.findRatingById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingDto> updateRating(@PathVariable Long id, @RequestBody RatingDto ratingDto) {
        ratingDto.setId(id);
        return ResponseEntity.ok(ratingService.updateRating(ratingDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}

