package com.auth.rivision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.rivision.model.JwtnResponse;
import com.auth.rivision.model.User;
import com.auth.rivision.serives.impl.UserServicesImpl;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserServicesImpl services;

	@PostMapping("/token")
	public JwtnResponse generateToken(@RequestParam String username, @RequestParam String password) throws Exception {

		String token = services.generateToken(username, password);

		return new JwtnResponse(token);
	}

	@PostMapping("/register")
	public User singUp(@RequestBody User user) {
		return services.singUp(user);
	}

	@GetMapping("/users")
	public List<User> getUsers() {

		List<User> users = this.services.getUsers();
		return users;

	}

}
