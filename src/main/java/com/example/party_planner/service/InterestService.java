package com.example.party_planner.service;
import com.example.party_planner.dto.InterestDto;
import com.example.party_planner.entity.Interest;
import com.example.party_planner.mapper.InterestMapper;
import com.example.party_planner.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterestService {
    private final InterestRepository interestRepository;
    private final InterestMapper interestMapper;

    public InterestDto createInterest(InterestDto interestDto) {
        Interest interest = interestMapper.toEntity(interestDto);
        return interestMapper.toDto(interestRepository.save(interest));
    }

    public Page<InterestDto> findAllInterests(Pageable pageable) {
        return interestRepository.findAll(pageable).map(interestMapper::toDto);
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
