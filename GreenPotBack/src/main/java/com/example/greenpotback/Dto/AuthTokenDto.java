package com.example.greenpotback.Dto;

import lombok.Data;

@Data
public class AuthTokenDto {
    String access_token;
    String refresh_token;

    public AuthTokenDto(String accessToken, String refreshToken){
        this.access_token = accessToken;
        this.refresh_token = refreshToken;
    }
}
