package com.example.springdemo.global.common.exception;

import com.example.springdemo.global.common.exception.base.BaseException;
import com.example.springdemo.global.common.exception.enums.ErrorCode;


public class InvalidUserInfoException extends BaseException {

	public InvalidUserInfoException(ErrorCode errorCode) {
		super(errorCode.getMessage(), errorCode);
	}

	public InvalidUserInfoException() {
		super(ErrorCode.INVALID_CREDENTIALS);
	}

}
