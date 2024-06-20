package com.example.party_planner.service;

import com.example.party_planner.dto.UserDto;
import com.example.party_planner.entity.User;
import com.example.party_planner.mapper.UserMapper;
import com.example.party_planner.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }
    @Cacheable("users")
    public UserDto findUserByEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return userMapper.toDto(userRepository.findByEmail(email).get());
        } else {
            return null;
        }

    }
    @Cacheable("users")
    public List<UserDto> findAllUsers() {
        return userMapper.toDtos(userRepository.findAll());
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
