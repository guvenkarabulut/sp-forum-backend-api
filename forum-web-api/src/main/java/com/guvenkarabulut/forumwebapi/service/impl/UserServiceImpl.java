package com.guvenkarabulut.forumwebapi.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.guvenkarabulut.forumwebapi.dto.request.UserRequest;
import com.guvenkarabulut.forumwebapi.dto.response.UserResponse;
import com.guvenkarabulut.forumwebapi.entity.User;
import com.guvenkarabulut.forumwebapi.exception.EmailAlreadyExistException;
import com.guvenkarabulut.forumwebapi.repository.UserRepository;
import com.guvenkarabulut.forumwebapi.service.UserService;
import com.guvenkarabulut.forumwebapi.utils.ImageConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ImageConverter imageConverter;
    private final Cloudinary cloudinary;

    @Override
    public UserResponse create(UserRequest userRequest) throws IOException {
        if (userRepository.findUserByEmail(userRequest.getEmail())!=null){
            throw new EmailAlreadyExistException(userRequest.getEmail()+" Email Already exist");
        }
        MultipartFile file = imageConverter.base64toImage(userRequest.getProfileImageBase64());
        Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        User user = User.builder()
                .email(userRequest.getEmail())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .password(userRequest.getPassword())
                .profilImageUrl(result.get("secure_url").toString())
                .createTime(new Date())
                .isActive(true)
                .build();

        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }
}
