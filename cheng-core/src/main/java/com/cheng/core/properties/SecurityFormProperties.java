/**
 * 
 */
package com.cheng.core.properties;

/**
 * @author jack.lin
 *
 */
public class SecurityFormProperties {

	private String loginPage;
	private String loginProcessingUrl;
	private Integer maximumSessions;
	private Boolean maxSessionsPreventsLogin;
	
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
	public Integer getMaximumSessions() {
		return maximumSessions;
	}
	public void setMaximumSessions(Integer maximumSessions) {
		this.maximumSessions = maximumSessions;
	}
	public Boolean getMaxSessionsPreventsLogin() {
		return maxSessionsPreventsLogin;
	}
	public void setMaxSessionsPreventsLogin(Boolean maxSessionsPreventsLogin) {
		this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
	}
}
