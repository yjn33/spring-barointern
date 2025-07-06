package com.example.springdemo.domain.user.entity;


import com.example.springdemo.domain.user.dto.request.UserInfoRequestDto;
import com.example.springdemo.domain.user.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Column(unique = true, nullable = false)
	private String username;

	private String nickname;

	@Column(nullable = false)
	private String password;


	// 처음 회원가입시 일단 UserRole.USER 으로 설정
	public User(String username, String password, String nickname) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.role = UserRole.USER;
	}


	public void updateUserInfo(UserInfoRequestDto requestDto) {
		this.nickname = requestDto.getNickname();
	}


}
