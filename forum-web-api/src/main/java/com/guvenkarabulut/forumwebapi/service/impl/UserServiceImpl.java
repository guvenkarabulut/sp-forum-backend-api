package com.guvenkarabulut.forumwebapi.service.impl;

import com.guvenkarabulut.forumwebapi.dto.request.UserRequest;
import com.guvenkarabulut.forumwebapi.dto.response.UserResponse;
import com.guvenkarabulut.forumwebapi.entity.User;
import com.guvenkarabulut.forumwebapi.repository.UserRepository;
import com.guvenkarabulut.forumwebapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserResponse create(UserRequest userRequest) {
        User user= User.builder()
                .email(userRequest.getEmail())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .password(userRequest.getPassword())
                .createTime(new Date())
                .isActive(true)
                .build();

        return modelMapper.map(userRepository.save(user),UserResponse.class);
    }
}
