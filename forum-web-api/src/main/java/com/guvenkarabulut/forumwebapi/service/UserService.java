package com.guvenkarabulut.forumwebapi.service;

import com.guvenkarabulut.forumwebapi.dto.request.UserRequest;
import com.guvenkarabulut.forumwebapi.dto.response.UserResponse;

public interface UserService {
    public UserResponse create(UserRequest user);
}
