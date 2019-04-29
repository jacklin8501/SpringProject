/**
 * 
 */
package com.cheng.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jack.lin
 *
 */
@ConfigurationProperties(prefix="cheng.security")
public class ChengSecurityProperties {

	private SecurityFormProperties form = new SecurityFormProperties();

	public SecurityFormProperties getForm() {
		return form;
	}

	public void setForm(SecurityFormProperties form) {
		this.form = form;
	}
}
