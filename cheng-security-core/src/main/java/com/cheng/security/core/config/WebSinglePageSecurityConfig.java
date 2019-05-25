/**
 * 
 */
package com.cheng.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

import com.cheng.core.properties.ChengProperties;
import com.cheng.security.core.config.handler.AuthenticationFailureHandlerImpl;
import com.cheng.security.core.config.handler.AuthenticationSuccessHandlerImpl;
import com.cheng.security.core.config.handler.LogoutSuccessHandlerImpl;
import com.cheng.security.core.config.manager.CustomerAccessDecisionManager;

/**
 * @author jack.lin
 *
 */
public class WebSinglePageSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired(required=false)
	private CustomerAccessDecisionManager customerAccessDecisionManager;
	
	@Autowired
	private ChengProperties cheng;

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
			//.addFilterAfter(new SessionFilter(sessionRegistry()), ConcurrentSessionFilter.class);
		
		if (null != customerAccessDecisionManager) {
			http
				.authorizeRequests().accessDecisionManager(customerAccessDecisionManager)
				.anyRequest().authenticated();
		}
		
		http
			.rememberMe().disable()
			.sessionManagement()
			.invalidSessionUrl(cheng.getSecurity().getSession().getInvalidSessionUrl())
			//.invalidSessionStrategy(new InvalidSessionStrategyImpl())
			.maximumSessions(cheng.getSecurity().getSession().getMaximumSessions())
			.maxSessionsPreventsLogin(cheng.getSecurity().getSession().getMaxSessionsPreventsLogin())
			.expiredUrl(cheng.getSecurity().getSession().getExpiredUrl())
			.sessionRegistry(sessionRegistry())
			.and()
			
			.and()
			.formLogin()
			.loginPage(cheng.getSecurity().getForm().getLoginPage())
			.loginProcessingUrl(cheng.getSecurity().getForm().getLoginProcessingUrl())
			.successHandler(new AuthenticationSuccessHandlerImpl())
			.failureHandler(new AuthenticationFailureHandlerImpl())
			.and()
			
			.logout()
			.logoutSuccessHandler(new LogoutSuccessHandlerImpl())
			.and()
			
			.httpBasic();
		
	}

	
}
