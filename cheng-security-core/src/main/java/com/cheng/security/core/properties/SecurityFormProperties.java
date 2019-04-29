/**
 * 
 */
package com.cheng.security.core.properties;

/**
 * @author jack.lin
 *
 */
public class SecurityFormProperties {

	private String loginPage;
	private String loginProcessingUrl;
	
	public String getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	public String getLoginProcessingUrl() {
		return loginProcessingUrl;
	}
	public void setLoginProcessingUrl(String loginProcessingUrl) {
		this.loginProcessingUrl = loginProcessingUrl;
	}
}
