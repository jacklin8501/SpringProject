/**
 * 
 */
package com.cheng.beetl.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cheng.beetlsql.config.BeetlSqlConfig;

/**
 * @author jack.lin
 *
 */
@Configuration
@Import(value={
		BeetlSqlConfig.class
})
public class DemoConfig {

}
