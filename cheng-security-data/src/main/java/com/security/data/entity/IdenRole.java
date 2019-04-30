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
@Table(name = "IDEN_ROLE")
public class IdenRole extends AbstractAuditor {

	@Column(name = "ROLE_CODE", length = 50, nullable = false, unique = true)
	private String roleCode;

	@Column(name = "ROLE_NAME", length = 100, nullable = false)
	private String roleName;

	@Column(name = "DESCRIPTION", length = 500)
	private String description;

	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled = true;

	@ManyToMany
	@JoinTable(name = "IDEN_USER_ROLE", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "ID") })
	private List<IdenUser> users;

	@ManyToMany
	@JoinTable(name = "IDEN_ROLE_PERMISSION", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "ID") })
	private List<IdenPermissin> permissions;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<IdenUser> getUsers() {
		return users;
	}

	public void setUsers(List<IdenUser> users) {
		this.users = users;
	}

	public List<IdenPermissin> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<IdenPermissin> permissions) {
		this.permissions = permissions;
	}
}
