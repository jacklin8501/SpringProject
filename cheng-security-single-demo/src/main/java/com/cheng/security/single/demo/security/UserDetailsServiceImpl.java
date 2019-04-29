/**
 * 
 */
package com.cheng.security.single.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author jack.lin
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(":: username = {}", username);
		return new User(username, passwordEncoder.encode("000000"), AuthorityUtils.createAuthorityList("ROLE_USER"));
	}

}
