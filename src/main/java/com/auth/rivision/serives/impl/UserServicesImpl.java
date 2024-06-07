package com.auth.rivision.serives.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.rivision.Repostory.UserRepostory;
import com.auth.rivision.model.JwtRequest;
import com.auth.rivision.model.JwtnResponse;
import com.auth.rivision.model.User;
import com.auth.rivision.security.JwtUtil;
import com.auth.rivision.security.MyUserDetailsService;
import com.auth.rivision.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepostory userRepostory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public User singUp(User user) {

		String password = user.getPassword();

		user.setPassword(passwordEncoder.encode(password));
		User save = this.userRepostory.save(user);

		save.setPassword(password);
		return save;

	}

	@Override
	public List<User> getUsers() {
		
		return this.userRepostory.findAll();

	}

	@Override
	public JwtnResponse login(User user) {

		return null;
	}

	@Override
	public String generateToken(String username, String password) throws Exception {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			throw new Exception("Invalid username or password");
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		return jwtUtil.generateToken(userDetails);
	}

}
