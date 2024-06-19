package com.example.party_planner.repository;

import com.example.party_planner.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    // Custom query methods can be added here
}

