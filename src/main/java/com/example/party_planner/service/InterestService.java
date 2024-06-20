package com.example.party_planner.service;

import com.example.party_planner.dto.InterestDto;
import com.example.party_planner.entity.Interest;
import com.example.party_planner.mapper.InterestMapper;
import com.example.party_planner.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestService {
    private final InterestRepository interestRepository;
    private final InterestMapper interestMapper;

    public InterestDto createInterest(InterestDto interestDto) {
        Interest interest = interestMapper.toEntity(interestDto);
        return interestMapper.toDto(interestRepository.save(interest));
    }

    public List<InterestDto> findAllInterests() {
        return interestMapper.toDtos(interestRepository.findAll());
    }

    public InterestDto findInterestById(Long id) {
        return interestMapper.toDto(interestRepository.findById(id).orElse(null));
    }

    public InterestDto updateInterest(InterestDto interestDto) {
        Interest interest = interestMapper.toEntity(interestDto);
        return interestMapper.toDto(interestRepository.save(interest));
    }

    public void deleteInterest(Long id) {
        interestRepository.deleteById(id);
    }
}
