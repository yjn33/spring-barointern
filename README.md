# 바로인턴 14기 자바 스프링 과제 #

2025년 7월 9일 수요일 기준 바로인턴 14기 2차 통과로 인한 배포 중단.
AWS 요금으로 현재 배포 중단하였습니다. 기능 동작을 보셔야 한다면 문의 바랍니다.

회원가입 POST
http://3.34.52.196:8080/auth/signup
```
{
    "username" : "john",
    "password" : "1234",
    "nickname" : "hello"
}
```

로그인 POST
http://3.34.52.196:8080/auth/login
```
{
    "username" : "john",
    "password" : "1234"
}
```

권한 부여 PATCH
http://3.34.52.196:8080/api/admin/users/{userId}/roles
```
http://3.34.52.196:8080/api/admin/users/1/roles
```

현재 자신의 UserInfo 조회 GET
http://3.34.52.196:8080/api/users


사용자 닉네임 변경 PUT
http://3.34.52.196:8080/api/users
```
{
    "nickname" : "newNickname"
}
```



---

## 회원가입 ##
<img width="353" height="331" alt="Image" src="https://github.com/user-attachments/assets/acf252af-4739-4f62-ad4f-007c51ae6d20" />
<br>회원가입</br>

<img width="353" height="331" alt="Image" src="https://github.com/user-attachments/assets/6839a6d6-af68-4c1b-a5e1-a793c7f0cb78" />
<br> 동일 username으로 회원가입시 예외처리 발생 </br>

## 로그인 ##
<img width="353" height="331" alt="Image" src="https://github.com/user-attachments/assets/e05ce40a-a338-45c7-b92a-01495a72f05b" />
<br>로그인시 JWT 토큰 생성</br>

<img width="353" height="331" alt="Image" src="https://github.com/user-attachments/assets/b6e0c8ad-b2db-4aaa-8596-51c270992439" />
<img width="353" height="331" alt="Image" src="https://github.com/user-attachments/assets/e7854fe9-6f80-4908-9d3a-f62fd3252fe8" />
<br> 아이디나 비밀번호가 틀린경우 예외처리 발생 </br>


## 권한 부여 ##
<img width="353" height="331" alt="Image" src="https://github.com/user-attachments/assets/4adb5d2e-fbd2-40c8-aa69-f812fe04f6b7" />
<br>1번 사용자에게 PATCH Method 사용시 Admin 권한 부여</br>


