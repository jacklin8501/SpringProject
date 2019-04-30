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

import org.springframework.http.HttpMethod;

import com.cheng.jpa.AbstractAuditor;

/**
 * @author jack.lin
 *
 */
@Entity
@Table(name = "IDEN_PERMISSION")
public class IdenPermissin extends AbstractAuditor {

	@Column(name = "PERM_CODE", length = 50, nullable = false, unique = true)
	private String permCode;

	@Column(name = "PERM_NAME", length = 100, nullable = false)
	private String permName;

	@Column(name = "URI", length = 255, nullable = false)
	private String uri;

	@Column(name = "HTTP_METHOD", length = 10, nullable = false)
	private String httpMethod = HttpMethod.GET.name();

	@Column(name = "DESCRIPTION", length = 500)
	private String description;

	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled = true;

	@ManyToMany
	@JoinTable(name = "IDEN_ROLE_PERMISSION", joinColumns = { @JoinColumn(name = "ID") }, inverseJoinColumns = { @JoinColumn(name = "ID") })
	private List<IdenRole> roles;

	public String getPermCode() {
		return permCode;
	}

	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
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

	public List<IdenRole> getRoles() {
		return roles;
	}

	public void setRoles(List<IdenRole> roles) {
		this.roles = roles;
	}
}
