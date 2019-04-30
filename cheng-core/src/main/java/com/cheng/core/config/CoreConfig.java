/**
 * 
 */
package com.cheng.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChenWebProperties;
import com.cheng.core.properties.ChengSecurityProperties;

/**
 * @author jack.lin
 *
 */
@Configuration
@EnableConfigurationProperties({ChengSecurityProperties.class, ChenWebProperties.class})
public class CoreConfig {

	@Bean
	public ApplicationContextAware springContextHolder() {
		return new SpringContextHolder();
	}
}
