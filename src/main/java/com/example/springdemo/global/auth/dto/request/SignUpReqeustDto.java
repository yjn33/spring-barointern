package com.example.springdemo.global.auth.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignUpReqeustDto {

	@NotBlank(message = "사용자 이름을 입력하세요")
	private String username;

	@NotBlank(message = "비밀번호를 입력하세요")
	//@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&]).{8,}$"
	//	, message = "대소문자, 숫자, 특수문자(!,@,#,$,%,^,&)를 포함한 8자리 이상으로 입력해주세요")
	private String password;

	@NotBlank(message = "닉네임은 필수 입니다")
	private String nickname;


}
