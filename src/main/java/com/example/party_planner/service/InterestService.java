package com.example.party_planner.service;

import com.example.party_planner.entity.Interest;
import com.example.party_planner.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestService {
    private final InterestRepository interestRepository;

    public Interest addInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    public List<Interest> findAllInterests() {
        return interestRepository.findAll();
    }

    public void deleteInterest(Long id) {
        interestRepository.deleteById(id);
    }
}
