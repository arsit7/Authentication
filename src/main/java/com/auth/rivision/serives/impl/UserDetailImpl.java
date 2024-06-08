package com.auth.rivision.serives.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.auth.rivision.model.User;

import lombok.Data;

@Data
public class UserDetailImpl implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String email;
	private String password;

	public UserDetailImpl(long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public static UserDetailImpl build(User user) {

		return new UserDetailImpl(user.getId(), user.getUserName(), user.getPassword());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	@Override
	public String getPassword() {

		return this.getPasswordfromResponse();
	}

	@Override
	public String getUsername() {

		String user = this.email;

		return user;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getPasswordfromResponse() {
		return password;
	}

}
