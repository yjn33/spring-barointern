package com.example.springdemo.global.auth.dto.response;


import com.example.springdemo.domain.user.entity.User;
import com.example.springdemo.domain.user.enums.UserRole;
import lombok.Getter;


@Getter
public class SignUpResponseDto {

	private final String username;

	private final String nickname;

	private final UserRole role;


	public SignUpResponseDto(User user) {
		this.username = user.getUsername();
		this.nickname = user.getNickname();
		this.role = user.getRole();
	}

}
