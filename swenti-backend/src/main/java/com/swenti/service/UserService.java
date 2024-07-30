package com.swenti.service;

import com.swenti.controller.dto.user.request.SelectUserRequestDto;
import com.swenti.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJpaRepository userJpaRepository;
    public String checkUserPassword(SelectUserRequestDto requestDto){
        return userJpaRepository.checkUserPassword(requestDto.id(), requestDto.password());
    }
}
