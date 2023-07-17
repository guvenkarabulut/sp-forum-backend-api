package com.guvenkarabulut.forumwebapi.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
}
