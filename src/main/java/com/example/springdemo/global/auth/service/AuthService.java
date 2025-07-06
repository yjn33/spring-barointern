package com.example.springdemo.global.auth.service;

import com.example.springdemo.domain.user.entity.User;
import com.example.springdemo.domain.user.repository.UserRepository;
import com.example.springdemo.global.auth.dto.request.LoginRequestDto;
import com.example.springdemo.global.auth.dto.request.SignUpReqeustDto;
import com.example.springdemo.global.auth.dto.response.LoginResponseDto;
import com.example.springdemo.global.auth.dto.response.SignUpResponseDto;
import com.example.springdemo.global.common.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;

	@Transactional
	public SignUpResponseDto signUp(SignUpReqeustDto request) {
		// 이미 존재하는 username 이므로 예외처리
		if (userRepository.existsByUsername(request.getUsername())) {
			throw new IllegalStateException("이미 존재하는 회원입니다");
		}

		// 회원가입 가능한 username
		// passwordencoder 필요
		User user = new User(request.getUsername(), request.getPassword(), request.getNickname());
		User savedUser = userRepository.save(user);

		return new SignUpResponseDto(user);
	}



	@Transactional(readOnly = true)
	public LoginResponseDto login(LoginRequestDto request) {
		User user = userRepository.findByUsername(request.getUsername()).orElseThrow(
			() -> new IllegalStateException("등록된 회원이 아닙니다")
		);

		String password = request.getPassword();
		if (!password.equals(user.getPassword())) {
			throw new IllegalStateException("비밀번호가 틀렸어요");
		}

		// 비밀번호가 맞을 경우
		String bearerJwt = jwtUtil.createToken(user.getId(), user.getUsername());
		return new LoginResponseDto(bearerJwt);
	}
}
