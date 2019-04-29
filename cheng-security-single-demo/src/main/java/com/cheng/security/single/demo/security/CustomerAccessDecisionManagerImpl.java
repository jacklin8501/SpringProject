/**
 * 
 */
package com.cheng.security.single.demo.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.cheng.security.core.config.CustomerAccessDecisionManager;

/**
 * @author jack.lin
 *
 */
@Component
public class CustomerAccessDecisionManagerImpl implements CustomerAccessDecisionManager {

	final Logger logger = LoggerFactory.getLogger(getClass());
	final AntPathMatcher matcher = new AntPathMatcher();
	
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configs)
			throws AccessDeniedException, InsufficientAuthenticationException {
		FilterInvocation fi = FilterInvocation.class.cast(object);
		String url = fi.getRequestUrl();
		logger.info(":: url = {}", url);
		
		if (!isLogin(authentication)) {
			boolean bool = matcher.match("/login.html/**", url);
			if (!bool) {
				throw new InsufficientAuthenticationException("please login");
			}
		}
		logger.info(":: access success");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
