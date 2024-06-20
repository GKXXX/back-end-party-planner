package com.example.party_planner.repository;
import com.example.party_planner.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Page<Rating> findAll(Pageable pageable);
}


