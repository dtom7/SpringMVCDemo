package com.example.springmvc.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.example.springmvc.domain.User;

public class TokenAuthenticationService {
	 
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
 
    private final TokenHandler tokenHandler;
 
    public TokenAuthenticationService(String secret, UserService userService) {
        tokenHandler = new TokenHandler(secret, userService);
    }
 
    public void addAuthentication(HttpServletResponse response, Authentication authentication) {
        final User user = (User)authentication;
        response.addHeader(AUTH_HEADER_NAME, tokenHandler.createTokenForUser(user));
    }
 
    public Authentication getAuthentication(HttpServletRequest request) {
    	System.out.println("TokenAuthenticationService .. getAuthentication");
        final String token = request.getHeader(AUTH_HEADER_NAME);
        System.out.println("getAuthentication token: " + token);
        if (token != null) {
            final User user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                return user;
            }
        }
        return null;
    }
}
