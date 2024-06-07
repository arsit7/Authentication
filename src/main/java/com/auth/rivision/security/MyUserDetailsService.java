package com.auth.rivision.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.rivision.Repostory.UserRepostory;
import com.auth.rivision.model.User;
import com.auth.rivision.serives.impl.UserDetailImpl;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepostory userRepostory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepostory.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);

		}

		return UserDetailImpl.build(user);
	}

}
