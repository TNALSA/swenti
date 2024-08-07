package com.swenti.controller.dto.user.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.swenti.model.User;
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record SelectUserInfoResponseDto(User user) {
}
