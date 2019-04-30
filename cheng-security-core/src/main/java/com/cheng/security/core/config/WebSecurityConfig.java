/**
 * 
 */
package com.cheng.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.session.ConcurrentSessionFilter;

import com.cheng.core.properties.ChengSecurityProperties;
import com.cheng.security.core.config.Strategy.InvalidSessionStrategyImpl;
import com.cheng.security.core.config.Strategy.SessionInformationExpiredStrategyImpl;
import com.cheng.security.core.config.filter.SessionFilter;
import com.cheng.security.core.config.handler.AuthenticationFailureHandlerImpl;
import com.cheng.security.core.config.handler.AuthenticationSuccessHandlerImpl;
import com.cheng.security.core.config.handler.LogoutSuccessHandlerImpl;
import com.cheng.security.core.config.manager.CustomerAccessDecisionManager;

/**
 * @author jack.lin
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired(required=false)
	private CustomerAccessDecisionManager customerAccessDecisionManager;
	@Autowired
	private ChengSecurityProperties security;

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.addFilterAfter(new SessionFilter(sessionRegistry()), ConcurrentSessionFilter.class);
		
		if (null != customerAccessDecisionManager) {
			http
				.authorizeRequests().accessDecisionManager(customerAccessDecisionManager)
				.anyRequest().authenticated();
		}
		
		http
			.sessionManagement()
			.invalidSessionStrategy(new InvalidSessionStrategyImpl())
			.maximumSessions(1)
			.maxSessionsPreventsLogin(false)
			.expiredSessionStrategy(new SessionInformationExpiredStrategyImpl())
			.sessionRegistry(sessionRegistry())
			.and()
			
			.and()
			.formLogin()
			.loginPage(security.getForm().getLoginPage())
			.loginProcessingUrl(security.getForm().getLoginProcessingUrl())
			.successHandler(new AuthenticationSuccessHandlerImpl())
			.failureHandler(new AuthenticationFailureHandlerImpl())
			.and()
			.logout()
			.logoutSuccessHandler(new LogoutSuccessHandlerImpl())
			.and()
			.httpBasic();
		
	}

	
}
