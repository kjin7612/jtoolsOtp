package io.jtools.totp.util.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtensibleAuthenticationFailureHandler implements AuthenticationFailureHandler, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.error("request: {}, response: {}, ", request, response, exception.getClass().getTypeName());
		if (exception instanceof BadCredentialsException) {
//			response.sendRedirect("/login?error=" + exception.getMessage());
			response.sendRedirect("/k2isOtp/login?error=" + exception.getMessage());
		} else if (exception instanceof InternalAuthenticationServiceException) {
//			response.sendRedirect("/login?error=" + exception.getMessage());
			response.sendRedirect("/k2isOtp/login?error=" + exception.getMessage());
		}
	}

}
