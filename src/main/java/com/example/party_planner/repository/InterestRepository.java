package com.example.party_planner.repository;

import com.example.party_planner.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    // Custom query methods can be added here
}

