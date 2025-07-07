package com.example.springdemo.domain.user.service;


import com.example.springdemo.domain.user.dto.response.UserInfoResponseDto;
import com.example.springdemo.domain.user.entity.User;
import com.example.springdemo.domain.user.enums.UserRole;
import com.example.springdemo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {
	private final UserRepository userRepository;


	@Transactional
	public UserInfoResponseDto setAdminRole(Long userId) {
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new IllegalArgumentException("해당 id를 가진 사용자가 없습니다"));

		user.updateUserRole(UserRole.ADMIN);

		userRepository.save(user);

		return new UserInfoResponseDto(user);
	}




}
