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

    @PostMapping
    public ResponseEntity<InterestDto> createInterest(@RequestBody InterestDto interestDto) {
        return ResponseEntity.ok(interestService.createInterest(interestDto));
    }

    @GetMapping
    public ResponseEntity<List<InterestDto>> getAllInterests() {
        return ResponseEntity.ok(interestService.findAllInterests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterestDto> getInterestById(@PathVariable Long id) {
        return ResponseEntity.ok(interestService.findInterestById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterestDto> updateInterest(@PathVariable Long id, @RequestBody InterestDto interestDto) {
        interestDto.setId(id);
        return ResponseEntity.ok(interestService.updateInterest(interestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterest(@PathVariable Long id) {
        interestService.deleteInterest(id);
        return ResponseEntity.noContent().build();
    }
}
