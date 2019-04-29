/**
 * 
 */
package com.cheng.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cheng.security.core.properties.ChengSecurityProperties;

/**
 * @author jack.lin
 *
 */
@Configuration
@EnableConfigurationProperties(value={ChengSecurityProperties.class})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired(required=false)
	private CustomerAccessDecisionManager customerAccessDecisionManager;
	@Autowired
	private ChengSecurityProperties security;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		if (null != customerAccessDecisionManager) {
			http
				.authorizeRequests().accessDecisionManager(customerAccessDecisionManager)
				.anyRequest().authenticated();
		}
		
		http
			.formLogin()
			.loginPage(security.getForm().getLoginPage())
			.loginProcessingUrl(security.getForm().getLoginProcessingUrl())
			.and()
			.httpBasic();
		
	}

	
}
