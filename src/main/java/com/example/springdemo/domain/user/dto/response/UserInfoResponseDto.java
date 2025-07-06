package com.example.springdemo.domain.user.dto.response;

import com.example.springdemo.domain.user.entity.User;
import com.example.springdemo.domain.user.enums.UserRole;
import lombok.Getter;



@Getter
public class UserInfoResponseDto {

	private String username;

	private String nickname;

	private UserRole role;


	public UserInfoResponseDto(User user) {
		this.username = user.getUsername();
		this.nickname = user.getNickname();
		this.role = user.getRole();
	}

}
