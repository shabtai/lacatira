package com.nsn.cloudstreet.rest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class RestLogoutSuccessHandler implements LogoutSuccessHandler{

	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Successfully logged out");
		
	}

}
