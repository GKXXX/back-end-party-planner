package com.example.party_planner.service;

import com.example.party_planner.dto.UserDto;
import com.example.party_planner.entity.User;
import com.example.party_planner.entity.Interest;
import com.example.party_planner.mapper.UserMapper;
import com.example.party_planner.repository.UserRepository;
import com.example.party_planner.repository.InterestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private InterestRepository interestRepository; // Ensure this repository is properly injected

    @Transactional
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        // Attach interests
        List<Interest> interests = userDto.getInterests().stream()
                .map(interestDto -> interestRepository.findById(interestDto.getId())
                        .orElseThrow(() -> new RuntimeException("Interest not found: " + interestDto.getId())))
                .collect(Collectors.toList());
        user.setInterests(interests);

        // Set author for comments
        user.getComments().forEach(comment -> comment.setAuthor(user));

        // Save user and return DTO
        return userMapper.toDto(userRepository.save(user));
    }

    @Cacheable("users")
    public UserDto findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElse(null);
    }

    @Cacheable("users")
    public Page<UserDto> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    public UserDto findUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
