package com.guvenkarabulut.forumwebapi.service.impl;

import com.guvenkarabulut.forumwebapi.dto.request.PostRequest;
import com.guvenkarabulut.forumwebapi.dto.response.PostResponse;
import com.guvenkarabulut.forumwebapi.entity.Post;
import com.guvenkarabulut.forumwebapi.entity.User;
import com.guvenkarabulut.forumwebapi.exception.PostIdNotFoundException;
import com.guvenkarabulut.forumwebapi.exception.UserNotFoundException;
import com.guvenkarabulut.forumwebapi.repository.PostRepository;
import com.guvenkarabulut.forumwebapi.repository.UserRepository;
import com.guvenkarabulut.forumwebapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public PostResponse createPost(PostRequest postRequest){
        User user = userRepository.findById(postRequest
                .getUserId())
                .orElseThrow(
                        () -> new UserNotFoundException(
                        postRequest.getUserId()+" this is is not found")
                );
        Post post = Post.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .createdDateTime(new Date())
                .user(user)
                .build();
        return modelMapper.map(postRepository.save(post),PostResponse.class);
    }
    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        return postList
                .stream()
                .map(post -> modelMapper.map(post,PostResponse.class))
                .toList();
    }
    @Override
    public PostResponse getPost(int postId) {
        Post post= postRepository.findById(postId).orElseThrow(
                () -> new PostIdNotFoundException(postId +" This id is not found")
        );
        return modelMapper.map(post,PostResponse.class);
    }

    @Override
    public void updatePost(int postId, PostRequest postRequest) {
        Post post= postRepository.findById(postId).orElseThrow(
                () -> new PostIdNotFoundException(postId + " This id is not found")
        );
        post.setContent(postRequest.getContent());
        post.setTitle(postRequest.getTitle());
        postRepository.save(post);
    }

    @Override
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }


}
