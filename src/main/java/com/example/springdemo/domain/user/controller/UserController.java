package com.example.springdemo.domain.user.controller;


import com.example.springdemo.domain.user.dto.request.UserInfoRequestDto;
import com.example.springdemo.domain.user.dto.response.UserInfoResponseDto;
import com.example.springdemo.domain.user.service.UserService;
import com.example.springdemo.global.auth.annotation.Auth;
import com.example.springdemo.global.auth.dto.AuthUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;


	@PutMapping("/users")
	public ResponseEntity<UserInfoResponseDto> updateUserInfo(
		@Auth AuthUser authUser,
		@Valid @RequestBody UserInfoRequestDto requestDto
	) {
		return ResponseEntity.ok(userService.updateUserInfo(authUser, requestDto));
	}


	@GetMapping("/users")
	public ResponseEntity<UserInfoResponseDto> checkMyUserInfo(
		@Auth AuthUser authUser
	) {
		return ResponseEntity.ok(userService.checkMyUserInfo(authUser));
	}



}
