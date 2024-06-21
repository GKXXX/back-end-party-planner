package com.example.party_planner.controller;

import com.example.party_planner.dto.UserDto;
import com.example.party_planner.mapper.UserMapper;
import com.example.party_planner.security.AuthRequest;
import com.example.party_planner.service.JwtService;
import com.example.party_planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.Encoder;
import java.util.Base64;

@Controller
@RequestMapping("/auth")
public class AuthentificationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    private Encoder encoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        String encodedPassword = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes());
        userDto.setPassword(encodedPassword);
        userService.createUser(userDto);
        return ResponseEntity.ok().body("Done.");
    }

    @PostMapping(value = "/connect")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        UserDto user = userService.findUserByEmail(authRequest.username());
        if (user.getEmail() != null) {
            String encodedPassword = Base64.getEncoder().encodeToString(authRequest.password().getBytes());
            if (user.getPassword().equals(encodedPassword)) {
                return ResponseEntity.ok().body(jwtService.generateToken(user));
            } else {
                return ResponseEntity.ok().body("Authentication failed.");
            }
        } else {
            return ResponseEntity.ok().body("User not found.");
        }
    }
}
