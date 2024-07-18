package com.cts.user.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
	private String password;
    private String username;
    
}