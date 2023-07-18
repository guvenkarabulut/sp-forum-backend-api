package com.guvenkarabulut.forumwebapi.dto.request;

import lombok.Data;

@Data
public class PostRequest {
    private int userId;
    private String title;
    private String content;
}
