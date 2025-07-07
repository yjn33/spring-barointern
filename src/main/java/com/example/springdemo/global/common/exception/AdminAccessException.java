package com.example.springdemo.global.common.exception;

import com.example.springdemo.global.common.exception.base.BaseException;
import com.example.springdemo.global.common.exception.enums.ErrorCode;

public class AdminAccessException extends BaseException {

	public AdminAccessException(ErrorCode errorCode) {
		super(errorCode.getMessage(), errorCode);
	}

	public AdminAccessException() {
		super(ErrorCode.ACCESS_DENIED);
	}
}
