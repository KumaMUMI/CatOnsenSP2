package com.example.catonsensp2.payload.response;

import lombok.Data;

@Data
public class UserInfoResponse {
    private Long id;
    private String username;
    private String role;

    public UserInfoResponse(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }
}
