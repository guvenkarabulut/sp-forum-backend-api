package com.guvenkarabulut.forumwebapi.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {
    private int id;
    private String title;
    private String content;
}
