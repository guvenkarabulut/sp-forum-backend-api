package com.guvenkarabulut.forumwebapi.utils;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
@Component
public class ImageConverter {
    public MultipartFile base64toImage(String base64) {
        String[] baseStr = base64.split(",");
        byte[] imageByte;
        if (base64.startsWith("data:image/png;base64,")){
           imageByte = Base64.getDecoder().decode(baseStr[1]);
        }else {
           imageByte = Base64.getDecoder().decode(baseStr[0]);
        }
        return new MockMultipartFile("file", "image.jpg", "image/jpeg", imageByte);
    }
}
