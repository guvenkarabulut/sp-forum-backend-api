package com.guvenkarabulut.forumwebapi.service;

import com.guvenkarabulut.forumwebapi.dto.request.PostRequest;
import com.guvenkarabulut.forumwebapi.dto.request.UserRequest;
import com.guvenkarabulut.forumwebapi.dto.response.PostResponse;

public interface PostService {
    public PostResponse createPost(PostRequest postRequest) throws RuntimeException;

}
