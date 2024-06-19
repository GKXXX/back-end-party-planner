package com.example.party_planner.repository;

import com.example.party_planner.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByLocation(String location);
    List<Event> findByType(String type);
    List<Event> findByIsPaid(Boolean isPaid);
}
