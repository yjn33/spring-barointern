package com.example.springdemo.domain.user.controller;


import com.example.springdemo.domain.user.dto.response.UserInfoResponseDto;
import com.example.springdemo.domain.user.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdminController {

	private final AdminService adminService;


	@PatchMapping("/admin/users/{userId}/roles")
	public ResponseEntity<UserInfoResponseDto> setAdminRole(
		@PathVariable Long userId) {

		return ResponseEntity.ok(adminService.setAdminRole(userId));
	}

}
