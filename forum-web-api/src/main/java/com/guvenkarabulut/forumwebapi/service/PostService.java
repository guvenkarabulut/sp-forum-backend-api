package com.guvenkarabulut.forumwebapi.service;

import com.guvenkarabulut.forumwebapi.dto.request.PostRequest;
import com.guvenkarabulut.forumwebapi.dto.request.UserRequest;
import com.guvenkarabulut.forumwebapi.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    public PostResponse createPost(PostRequest postRequest) throws RuntimeException;
    public List<PostResponse> getAllPosts();
    public PostResponse getPost(int postId);
    public void updatePost(int postId,PostRequest postRequest);
    public void deletePost(int postId);
}
