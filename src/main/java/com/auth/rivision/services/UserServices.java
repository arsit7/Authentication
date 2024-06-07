package com.auth.rivision.services;

import java.util.List;

import com.auth.rivision.model.JwtnResponse;
import com.auth.rivision.model.User;

public interface UserServices {

	User singUp(User user);

	List<User> getUsers();

	JwtnResponse login(User user);
	
	 String generateToken(String username, String password) throws Exception;

}
