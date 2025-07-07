package com.example.springdemo.global.common.exception.handler;


import com.example.springdemo.global.common.exception.base.BaseException;
import com.example.springdemo.global.common.exception.dto.ErrorResponseDto;
import com.example.springdemo.global.common.exception.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponseDto> handle(HttpRequestMethodNotSupportedException e) {
		log.error("HttpRequestMethodNotSupportedException", e);
		return createErrorResponseEntity(ErrorCode.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(BaseException.class)
	protected ResponseEntity<ErrorResponseDto> handle(BaseException e) {
		log.error("BaseException e");
		return createErrorResponseEntity(e.getErrorCode());
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponseDto> handle(Exception e) {
		e.printStackTrace();
		log.error("Exception e");
		return createErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
	}


	private ResponseEntity<ErrorResponseDto> createErrorResponseEntity(ErrorCode errorCode) {
		return new ResponseEntity<>(
			ErrorResponseDto.of(errorCode),
			errorCode.getStatus()
		);
	}


}
