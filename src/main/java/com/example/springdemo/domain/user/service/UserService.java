package com.example.springdemo.domain.user.service;


import com.example.springdemo.domain.user.dto.request.UserInfoRequestDto;
import com.example.springdemo.domain.user.dto.response.UserInfoResponseDto;
import com.example.springdemo.domain.user.entity.User;
import com.example.springdemo.domain.user.repository.UserRepository;
import com.example.springdemo.global.auth.annotation.Auth;
import com.example.springdemo.global.auth.dto.AuthUser;
import com.example.springdemo.global.common.exception.UserNotExistException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;


	@Transactional
	public UserInfoResponseDto updateUserInfo(
		AuthUser authUser, UserInfoRequestDto requestDto) {

		User user = userRepository.findById(authUser.getId())
			.orElseThrow(() -> new IllegalStateException("해당 사용자는 존재하지 않습니다"));

		user.updateUserInfo(requestDto);

		userRepository.save(user);

		return new UserInfoResponseDto(user);
	}


	@Transactional
	public UserInfoResponseDto checkMyUserInfo(AuthUser authUser) {

		User user = userRepository.findById(authUser.getId())
			.orElseThrow(UserNotExistException::new);

		return new UserInfoResponseDto(user);
	}



}
