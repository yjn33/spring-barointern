package com.example.springdemo.global.auth.controller;

import com.example.springdemo.global.auth.dto.request.LoginRequestDto;
import com.example.springdemo.global.auth.dto.request.SignUpReqeustDto;
import com.example.springdemo.global.auth.dto.response.LoginResponseDto;
import com.example.springdemo.global.auth.dto.response.SignUpResponseDto;
import com.example.springdemo.global.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/auth/signup")
	public ResponseEntity<SignUpResponseDto> signUp(
		@Valid @RequestBody SignUpReqeustDto request
	) {
		return ResponseEntity.ok(authService.signUp(request));
	}

	@PostMapping("/auth/login")
	public ResponseEntity<LoginResponseDto> login(
		@RequestBody LoginRequestDto request
	) {
		return ResponseEntity.ok(authService.login(request));
	}
}
