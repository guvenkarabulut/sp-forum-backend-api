package com.guvenkarabulut.forumwebapi.controller;

import com.guvenkarabulut.forumwebapi.dto.request.PostRequest;
import com.guvenkarabulut.forumwebapi.dto.request.UserRequest;
import com.guvenkarabulut.forumwebapi.dto.response.PostResponse;
import com.guvenkarabulut.forumwebapi.dto.response.UserResponse;
import com.guvenkarabulut.forumwebapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllPosts(){
        return null;
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.createPost(postRequest));
    }
}
