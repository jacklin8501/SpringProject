/**
 * 
 */
package com.security.data.entity.auditor;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.cheng.jpa.AbstractAuditor;
import com.cheng.jpa.Processor.AuditorPrePesistProcessor;

/**
 * @author jack.lin
 * 要起作用， 必须配置为bean
 */
public class UsernamePasswordAuthenticationAuditorPrePesistProcessor implements AuditorPrePesistProcessor {

	@Override
	public void proceeding(AbstractAuditor auditor) {
		Date now = new Date();
		auditor.setCreateDate(now);
		auditor.setLastModifiedDate(now);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (null != auth) {
			Object principal = auth.getPrincipal();
			if (UserDetails.class.isInstance(principal)) {
				UserDetails user = (UserDetails) principal;
				auditor.setCreateBy(user.getUsername());
				auditor.setLastModifiedBy(user.getUsername());
			}
		}
		
	}

}
