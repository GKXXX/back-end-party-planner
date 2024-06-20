package com.example.party_planner.service;
import com.example.party_planner.dto.RatingDto;
import com.example.party_planner.entity.Rating;
import com.example.party_planner.mapper.RatingMapper;
import com.example.party_planner.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = ratingMapper.toEntity(ratingDto);
        return ratingMapper.toDto(ratingRepository.save(rating));
    }

    public Page<RatingDto> findAllRatings(Pageable pageable) {
        return ratingRepository.findAll(pageable).map(ratingMapper::toDto);
    }

    public RatingDto findRatingById(Long id) {
        return ratingMapper.toDto(ratingRepository.findById(id).orElse(null));
    }

    public RatingDto updateRating(RatingDto ratingDto) {
        Rating rating = ratingMapper.toEntity(ratingDto);
        return ratingMapper.toDto(ratingRepository.save(rating));
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
