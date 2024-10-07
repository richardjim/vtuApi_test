package com.dev.vtu_api.auth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    public AuthenticationResponse(String token) {
        this.token = token;
    }

}
