package com.guvenkarabulut.forumwebapi.controller;

import com.guvenkarabulut.forumwebapi.dto.request.PostRequest;
import com.guvenkarabulut.forumwebapi.dto.response.PostResponse;
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
    public ResponseEntity<List<PostResponse>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable int id){
        return ResponseEntity.ok(postService.getPost(id));
    }
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.createPost(postRequest));
    }
    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id,@RequestBody PostRequest postRequest){
        postService.updatePost(id,postRequest);
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        postService.deletePost(id);
    }
}
