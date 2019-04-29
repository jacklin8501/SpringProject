/**
 * 
 */
package com.cheng.security.core.config.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * @author jack.lin
 *
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		
		logger.info(":: login failure.");
		
		response.setStatus(403);
		response.setCharacterEncoding("UTF-8");
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		
		try ( PrintWriter writer = response.getWriter(); ) {
			logger.info(":: error message = {}", ex.getMessage());
			writer.write(ex.getMessage());
		}
	}

}
