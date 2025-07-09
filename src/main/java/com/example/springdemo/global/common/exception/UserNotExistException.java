package com.example.springdemo.global.common.exception;

import com.example.springdemo.global.common.exception.base.BaseException;
import com.example.springdemo.global.common.exception.enums.ErrorCode;

public class UserNotExistException extends BaseException {


	public UserNotExistException(ErrorCode errorCode) {
		super(errorCode.getMessage(), errorCode);
	}

	public UserNotExistException() {
		super(ErrorCode.USER_NOT_EXISTS);
	}

}
