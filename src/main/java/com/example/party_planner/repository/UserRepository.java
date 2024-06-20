package com.example.party_planner.repository;

import com.example.party_planner.entity.Event;
import com.example.party_planner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("insert into Event e VALUES (:id_participant,:id_event)")
    Optional<Event> addParticipant(Long id_participant,Long id_event);
}

