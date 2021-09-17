package com.mycompany.webapp.security;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class Ch17AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	private static final Logger logger = LoggerFactory.getLogger(Ch17AuthenticationSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		logger.info("실행");
		super.onAuthenticationSuccess(request, response, chain, authentication);
	}
}
