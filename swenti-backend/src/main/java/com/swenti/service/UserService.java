package com.swenti.service;

import com.swenti.controller.dto.user.request.SelectUserRequestDto;
import com.swenti.controller.dto.user.request.UpdateUserInfoRequestDto;
import com.swenti.model.User;
import com.swenti.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJpaRepository userJpaRepository;
    public String checkUserPassword(SelectUserRequestDto body){
        return userJpaRepository.checkUserPassword(body.id(), body.password());
    }

    public User getUserInfo(String userid){
        return userJpaRepository.getUesrInfo(userid);
    }

    @Transactional
    public void updateUserInfo(UpdateUserInfoRequestDto body){
        System.out.println("[변경할 비밀번호]: "+body.contact());
        userJpaRepository.updateUserInfo(body.contact(), body.userid());
    }
}
