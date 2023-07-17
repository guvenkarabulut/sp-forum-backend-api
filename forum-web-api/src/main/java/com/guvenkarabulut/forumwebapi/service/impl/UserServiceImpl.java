package com.guvenkarabulut.forumwebapi.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.guvenkarabulut.forumwebapi.dto.request.UserRequest;
import com.guvenkarabulut.forumwebapi.dto.response.UserResponse;
import com.guvenkarabulut.forumwebapi.entity.User;
import com.guvenkarabulut.forumwebapi.repository.UserRepository;
import com.guvenkarabulut.forumwebapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Cloudinary cloudinary;

    @Override
    public UserResponse create(UserRequest userRequest) throws IOException {
        MultipartFile file = base64toImage(userRequest.getProfileImageBase64());
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

    private MultipartFile base64toImage(String base64) {
        String[] baseStr = base64.split(",");
        byte[] imageByte = Base64.getDecoder().decode(baseStr[0]); // Değerler arasındaki virgülü değiştirdik
        return new MockMultipartFile("file", "image.jpg", "image/jpeg", imageByte);
    }
}
