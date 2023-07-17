package com.guvenkarabulut.forumwebapi.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryConfigBean() {
        Cloudinary cloudinary = null;
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "aaaa");
        config.put("api_key", "aaaa");
        config.put("api_secret", "aaaa");
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }
}
