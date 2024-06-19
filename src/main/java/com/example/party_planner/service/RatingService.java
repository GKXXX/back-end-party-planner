package com.example.party_planner.service;

import com.example.party_planner.entity.Rating;
import com.example.party_planner.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> findAllRatings() {
        return ratingRepository.findAll();
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
