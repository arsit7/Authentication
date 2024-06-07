package com.auth.rivision.exceptionHandle;

public class JwtTokenException extends RuntimeException{
	
	public JwtTokenException(String message) {
		super(message);
    }

}
