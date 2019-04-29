/**
 * 
 */
package com.cheng.security.core.config.Strategy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * @author jack.lin
 *
 */
public class InvalidSessionStrategyImpl implements InvalidSessionStrategy {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		try(PrintWriter writer = response.getWriter();) {
			writer.write("please login");
		}
	}

}
