package com.guvenkarabulut.forumwebapi.exception;

public class PostIdNotFoundException extends RuntimeException{
    public PostIdNotFoundException(String message) {
        super(message);
    }
}
