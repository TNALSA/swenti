package com.swenti.controller;

import com.swenti.controller.dto.UserRequestDto;
import com.swenti.repository.UserJpaRepository;
import com.swenti.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    @GetMapping("/login")
    public String loginPage(){
        return "login.html";
    }

    @PostMapping("/login/request")
    public String loginRequest(@RequestBody UserRequestDto body){
        System.out.println(body.id());
        System.out.println(body.password());

        String result = userService.checkUserPassword(body);

        if (result.equals("1"))
            return "Home.html";
        else
            return "Home.html";
    }
}
