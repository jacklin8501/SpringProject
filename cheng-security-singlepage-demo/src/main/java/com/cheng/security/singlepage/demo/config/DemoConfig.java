/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cheng.beetl.config.BeetlWebConfig;
import com.cheng.security.core.config.WebSinglePageSecurityConfig;
import com.cheng.security.core.config.manager.CustomerAccessDecisionManager;
import com.cheng.security.core.config.manager.impl.CustomerAccessDecisionManagerImpl;

/**
 * @author jack.lin
 *
 */
@Configuration
@Import({
	WebSinglePageSecurityConfig.class, BeetlWebConfig.class
})
public class DemoConfig {

	/**
	 * 使用默认访问策略
	 * @return
	 */
	@Bean
	public CustomerAccessDecisionManager customerAccessDecisionManagerImpl() {
		return new CustomerAccessDecisionManagerImpl();
	}
	
	/*public AccessUrlIfFunction accessUrlIfFunction () {
		AccessUrlIfFunction fn = new AccessUrlIfFunction();
		fn.setServletContext(servletContext);
		return fn;
	}*/
	
}
