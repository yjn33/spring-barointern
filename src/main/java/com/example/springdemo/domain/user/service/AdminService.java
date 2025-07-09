package com.example.springdemo.domain.user.service;


import com.example.springdemo.domain.user.dto.response.UserInfoResponseDto;
import com.example.springdemo.domain.user.entity.User;
import com.example.springdemo.domain.user.enums.UserRole;
import com.example.springdemo.domain.user.repository.UserRepository;
import com.example.springdemo.global.common.exception.UserNotExistException;
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
			.orElseThrow(UserNotExistException::new); // 존재하지 않는 사용자일경우

		user.updateUserRole(UserRole.ADMIN);

		userRepository.save(user);

		return new UserInfoResponseDto(user);
	}




}
