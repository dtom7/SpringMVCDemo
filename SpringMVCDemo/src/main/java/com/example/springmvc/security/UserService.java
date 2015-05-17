package com.example.springmvc.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.springmvc.domain.User;

public class UserService {

	public User loadUserByUsername(String username) {
		List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User("bob", "test", grantedAuths);
	}

}
