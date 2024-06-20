package com.example.party_planner.repository;
import com.example.party_planner.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findAll(Pageable pageable);
    Page<Event> findByIsPaid(Boolean isPaid, Pageable pageable); // Custom pagination method

    Page<Event> findByLocation(String location,Pageable pageable);
    Page<Event> findByInterest(Long id_interest,Pageable pageable);

}
