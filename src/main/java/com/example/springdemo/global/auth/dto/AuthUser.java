package com.example.springdemo.global.auth.dto;

import lombok.Getter;

@Getter
public class AuthUser {

	private final Long id;
	private final String username;


	public AuthUser(Long id, String username) {
		this.id = id;
		this.username = username;
	}
}
