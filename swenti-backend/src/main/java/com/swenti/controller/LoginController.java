package com.swenti.controller;

import com.swenti.controller.dto.user.UserRequestDto;
import com.swenti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@SessionAttributes("user")
public class LoginController {

    private final UserService userService;
    @GetMapping("/login")
    public String loginPage(){
        return "loginPage.html";
    }

    @PostMapping("/login/request")
    public String loginRequest(@RequestBody UserRequestDto body, Model model){

//        System.out.println(body.id());
//        System.out.println(body.password());

        int result = Integer.parseInt(userService.checkUserPassword(body));
        System.out.println("Login result: " + result);

        if (result > 0) {
            System.out.println("Login Success");
            model.addAttribute("user",body.id());
            return "homePage.html";
        } else {
            // 로그인 실패에 대한 예외 처리
            System.out.println("Login Fail");
            model.addAttribute("messgae","로그인에 실패하였습니다.");
            return "loginPage.html";
            }
    }
}
