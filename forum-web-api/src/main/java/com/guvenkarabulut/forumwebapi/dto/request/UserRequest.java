package com.guvenkarabulut.forumwebapi.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserRequest {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String profileImageBase64;
}
