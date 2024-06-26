package com.swenti.service;

import com.swenti.controller.dto.UserRequestDto;
import com.swenti.model.User;
import com.swenti.repository.ArticleJpaRepository;
import com.swenti.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJpaRepository userJpaRepository;
    public String checkUserPassword(UserRequestDto requestDto){
        String result = userJpaRepository.checkUserPassword(requestDto.id(), requestDto.password());
        return result;
    }
}
