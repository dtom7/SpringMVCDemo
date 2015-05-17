package com.example.springmvc.security;

import com.example.springmvc.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenHandler {
	 
    private final String secret;
    private final UserService userService;
 
    public TokenHandler(String secret, UserService userService) {
        this.secret = secret;
        this.userService = userService;
    }
 
    public User parseUserFromToken(String token) {
    	System.out.println("TokenHandler .. parseUserFromToken");
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userService.loadUserByUsername(username);
    }
 
    public String createTokenForUser(User user) {
        return Jwts.builder()
                .setSubject(user.getName())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
