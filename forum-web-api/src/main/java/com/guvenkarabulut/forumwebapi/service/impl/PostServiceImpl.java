package com.guvenkarabulut.forumwebapi.service.impl;

import com.guvenkarabulut.forumwebapi.dto.request.PostRequest;
import com.guvenkarabulut.forumwebapi.dto.response.PostResponse;
import com.guvenkarabulut.forumwebapi.entity.Post;
import com.guvenkarabulut.forumwebapi.repository.PostRepository;
import com.guvenkarabulut.forumwebapi.repository.UserRepository;
import com.guvenkarabulut.forumwebapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public PostResponse createPost(PostRequest postRequest){
        Post post = Post.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .createdDateTime(new Date())
                .user(userRepository.findById(postRequest.getUserId()).orElseThrow())
                .build();
        return modelMapper.map(postRepository.save(post),PostResponse.class);
    }
}
