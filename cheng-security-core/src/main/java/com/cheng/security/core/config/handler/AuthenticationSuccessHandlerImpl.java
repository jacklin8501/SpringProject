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
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jack.lin
 *
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		logger.info(":: login success.");
		response.setCharacterEncoding("UTF-8");
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		
		try ( PrintWriter writer = response.getWriter(); ) {
			String json = JSONObject.toJSONString(authentication.getPrincipal());
			logger.info(":: JSON info = {}", json);
			writer.write(json);
		}
	}

}
