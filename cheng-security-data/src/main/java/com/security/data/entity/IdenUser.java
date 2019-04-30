/**
 * 
 */
package com.security.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cheng.jpa.AbstractAuditor;

/**
 * @author jack.lin
 *
 */
@Entity
@Table(name = "IDEN_USER")
public class IdenUser extends AbstractAuditor {

	@Column(name = "USERNAME", length = 36, nullable = false, unique = true)
	private String username;

	@Column(name = "PASSWORD", length = 150, nullable = false)
	private String password;

	@Column(name = "ACCOUNT_NON_EXPIRED", nullable = false)
	private Boolean accountNonExpired = true;

	@Column(name = "ACCOUNT_NON_LOCKED", nullable = false)
	private Boolean accountNonLocked = true;

	@Column(name = "CREDENTIALS_NON_EXPIRED", nullable = false)
	private Boolean credentialsNonExpired = true;

	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled = true;

	@ManyToMany
	@JoinTable(name = "IDEN_USER_ROLE", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "ID") })
	private List<IdenRole> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<IdenRole> getRoles() {
		return roles;
	}

	public void setRoles(List<IdenRole> roles) {
		this.roles = roles;
	}
}
