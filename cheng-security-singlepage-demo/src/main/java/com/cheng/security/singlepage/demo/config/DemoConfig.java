/**
 * 
 */
package com.cheng.security.singlepage.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cheng.security.core.config.WebSinglePageSecurityConfig;

/**
 * @author jack.lin
 *
 */
@Configuration
@Import({
	WebSinglePageSecurityConfig.class
})
public class DemoConfig {

}
