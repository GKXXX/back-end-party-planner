package com.example.party_planner.repository;

import com.example.party_planner.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    Page<Interest> findAll(Pageable pageable);
}


