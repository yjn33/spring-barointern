package com.example.springdemo.global.auth.dto.response;


import lombok.Getter;


@Getter
public class LoginResponseDto {

	private final String bearerJwt;


	public LoginResponseDto(String bearerJwt) {
		this.bearerJwt = bearerJwt;
	}

}
