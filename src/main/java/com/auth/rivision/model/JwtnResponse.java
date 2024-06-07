package com.auth.rivision.model;

import lombok.Data;

@Data
public class JwtnResponse {

	private final String jwt;

	public JwtnResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}
