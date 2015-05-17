package com.example.springmvc.domain;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class User extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;

	public User(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);

	}

}