package com.example.springdemo.global.common.exception;

import com.example.springdemo.global.common.exception.base.BaseException;
import com.example.springdemo.global.common.exception.enums.ErrorCode;

public class UserExistException extends BaseException {

	public UserExistException(ErrorCode errorCode) {
		super(errorCode.getMessage(), errorCode);
	}

	public UserExistException() {
		super(ErrorCode.USER_ALREADY_EXISTS);
	}
}
