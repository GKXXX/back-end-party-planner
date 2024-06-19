package com.example.party_planner.service;

import com.example.party_planner.dto.UserDto;
import com.example.party_planner.entity.User;
import com.example.party_planner.mapper.UserMapper;
import com.example.party_planner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public UserDto findUserByEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return userMapper.toDto(userRepository.findByEmail(email).get());
        } else {
            return null;
        }

    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
