package com.swenti.controller;

import com.swenti.controller.dto.user.UserRequestDto;
import com.swenti.controller.dto.user.UserResponseDto;
import com.swenti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@SessionAttributes("user")
public class UserController {

    private final UserService userService;


    /**
     * 메서드 명: loginRequest()
     * 기능: 사용자 로그인
     * checkUserPassword()를 통해 먼저 사용자 아이디와 비밀번호에 대한 유효성 검증
     * 이후 결과 값에 따라 로그인 성공 여부를 결정하고 결과 값을 클라이언트에게 반환
     * @param body
     * @return UserResponseDto(isSuccess, comment)
     */
    @PostMapping("/login/request")
    public UserResponseDto loginRequest(@RequestBody UserRequestDto body){
        int result = Integer.parseInt(userService.checkUserPassword(body));
        System.out.println("Login result: " + result);

        if (result > 0) {
            return new UserResponseDto(true, "로그인 성공");
        } else {
            // 로그인 실패에 대한 예외 처리
            return new UserResponseDto(false, "입력하신 정보가 일치하지 않습니다.");
        }
    }
}
