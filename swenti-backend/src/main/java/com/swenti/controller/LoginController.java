package com.swenti.controller;

import com.swenti.controller.dto.user.UserRequestDto;
import com.swenti.controller.dto.user.UserResponseDto;
import com.swenti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@SessionAttributes("user")
public class LoginController {

    private final UserService userService;

    @PostMapping("/login/request")
    public UserResponseDto loginRequest(@RequestBody UserRequestDto body, Model model){
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
