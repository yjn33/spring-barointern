package com.example.springdemo.global.auth.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class LoginRequestDto {

	@NotBlank(message = "사용자 이름을 입력하세요")
	private String username;

	@NotBlank(message = "비밀번호 입력은 필수 입니다")
	private String password;

}
