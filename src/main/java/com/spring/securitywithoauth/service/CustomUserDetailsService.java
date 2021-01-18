package com.spring.securitywithoauth.service;


import com.spring.securitywithoauth.model.CustomUser;
import com.spring.securitywithoauth.model.UserEntity;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {



	@Override
	public UserDetails loadUserByUsername(String input) {

		UserEntity userEntity =new UserEntity();
		userEntity.setId("1");
		userEntity.setName("zaman@abc.com");
		userEntity.setEmailId("zaman@abc.com");
		userEntity.setPassword("1234");
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMINISTRATOR");
		GrantedAuthority grantedAuthority1 = new SimpleGrantedAuthority("xyz");
		grantedAuthoritiesList.add(grantedAuthority);
		grantedAuthoritiesList.add(grantedAuthority1);
		userEntity.setGrantedAuthoritiesList(grantedAuthoritiesList);

		CustomUser user = new CustomUser(userEntity);

		if (user == null)
			throw new BadCredentialsException("Bad credentials");

		new AccountStatusUserDetailsChecker().check(user);

		return user;
	}
}
