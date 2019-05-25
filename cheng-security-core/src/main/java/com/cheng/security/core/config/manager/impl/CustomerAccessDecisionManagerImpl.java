/**
 * 
 */
package com.cheng.security.core.config.manager.impl;

import static com.cheng.security.core.utils.AuthenticationUtils.isAnonymousUser;
import static com.cheng.security.core.utils.RequestUtils.calculateUri;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.AntPathMatcher;

import com.cheng.security.core.config.Strategy.AccessStrategy;
import com.cheng.security.core.config.Strategy.impl.AnyRequestAuthenticatedAccessStrategyImpl;
import com.cheng.security.core.config.Strategy.impl.PermitAllRequestAccessStrategyImpl;
import com.cheng.security.core.config.Strategy.impl.DefaultPermitAllRequestAccessStrategyImpl;
import com.cheng.security.core.config.manager.CustomerAccessDecisionManager;

/**
 * @author jack.lin
 *
 */
public class CustomerAccessDecisionManagerImpl implements CustomerAccessDecisionManager {

	final Logger logger = LoggerFactory.getLogger(getClass());
	final AntPathMatcher pathMatcher = new AntPathMatcher();
	
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		FilterInvocation fi = (FilterInvocation) object;
		HttpServletRequest request = fi.getHttpRequest();
		
		String uri = calculateUri(request);
		logger.info(":: Pre-access uri {}", uri);
		
		AccessStrategy publishRequestAccessStrategy = new DefaultPermitAllRequestAccessStrategyImpl();
		boolean isPublish = publishRequestAccessStrategy.canAccess(request);
		if (isPublish) {
			return;
		}
		
		AccessStrategy permitAllRequestAccessStrategy = new PermitAllRequestAccessStrategyImpl();
		boolean isPermitAll = permitAllRequestAccessStrategy.canAccess(request);
		if (isPermitAll) {
			return;
		}
		
		if (isAnonymousUser(authentication)) {
			logger.info(":: AnonymousUser 无法鉴别身份");
			logger.info(":: Refuse access uri {}", uri);
			throw new InsufficientAuthenticationException("AnonymousUser 无法鉴别身份!");
		}
		
		AccessStrategy anyRequestAuthenticatedAccessStrategy = new AnyRequestAuthenticatedAccessStrategyImpl();
		boolean isAnyRequestAuthenticated = anyRequestAuthenticatedAccessStrategy.canAccess(request);
		if (isAnyRequestAuthenticated) {
			return;
		}
		
		logger.info(":: 访问被拒绝，权限不足!");
		logger.info(":: Refuse access uri {}", uri);
		throw new AccessDeniedException("访问被拒绝，权限不足!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
