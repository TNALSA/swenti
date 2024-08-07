package com.swenti.controller;

import com.swenti.controller.dto.user.request.SelectUserRequestDto;
import com.swenti.controller.dto.user.request.UpdateUserInfoRequestDto;
import com.swenti.controller.dto.user.response.SelectUserInfoResponseDto;
import com.swenti.controller.dto.user.response.SelectUserResponseDto;
import com.swenti.message.ReturnMessage;
import com.swenti.model.User;
import com.swenti.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public SelectUserResponseDto loginRequest(@RequestBody SelectUserRequestDto body){
        int result = Integer.parseInt(userService.checkUserPassword(body));
        System.out.println("Login result: " + result);
        if (result > 0) {
            return new SelectUserResponseDto(true, ReturnMessage.SUCCESS.getComment());
        } else {
            // 로그인 실패에 대한 예외 처리
            return new SelectUserResponseDto(false, ReturnMessage.NOT_MATCH.getComment());
        }
    }

    @GetMapping("/info")
    public SelectUserInfoResponseDto getUserInfo(@RequestParam String userid){
        User user = userService.getUserInfo(userid);
        return new SelectUserInfoResponseDto(user);
    }

    @PutMapping("/info/update")
    public void updateUserInfo(@RequestBody UpdateUserInfoRequestDto body){
        userService.updateUserInfo(body);
    }

}
