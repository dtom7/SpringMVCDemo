package com.example.springmvc.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.springmvc.domain.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context.xml")
@WebAppConfiguration
public class HomeControllerTest {

	@Autowired
	private MockHttpServletRequest request;
	@Autowired
	private MockHttpSession session;
	@Autowired
	private LoginService loginService;

	@Test
	public void requestScope() throws Exception {
		request.setParameter("userId", "rock");
		request.setParameter("password", "rock");
		assertTrue(loginService.isValid());
	}

}
