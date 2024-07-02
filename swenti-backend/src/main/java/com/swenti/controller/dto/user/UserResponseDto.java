package com.swenti.controller.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL) // json 형태로 만들어주는 annotation
public record UserResponseDto(boolean isSuccess, String comment) {
}
