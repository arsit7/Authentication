package com.auth.rivision.model;

import lombok.Data;

@Data
public class JwtRequest {
	
	private long id;

	private String userName;

	private String password;;

}
