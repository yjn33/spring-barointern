package com.example.springdemo.global.common.exception.dto;


import com.example.springdemo.global.common.exception.enums.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponseDto {

	private String code;

	private String message;

	private ErrorResponseDto(final ErrorCode code) {
		this.message = code.getMessage();
		this.code = code.getCode();
	}

	public ErrorResponseDto(final ErrorCode code, final String message) {
		this.message = message;
		this.code = code.getCode();
	}


	public static ErrorResponseDto of(final ErrorCode code) {
		return new ErrorResponseDto(code);
	}

	public static ErrorResponseDto of(final ErrorCode code, final String message) {
		return new ErrorResponseDto(code, message);
	}


}
