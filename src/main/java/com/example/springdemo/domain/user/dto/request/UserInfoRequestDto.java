package com.example.springdemo.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


@Getter
public class UserInfoRequestDto {

	@NotBlank(message = "수정할 닉네임을 입력하세요")
	private String nickname;

}
