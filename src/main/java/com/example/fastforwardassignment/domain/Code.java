package com.example.fastforwardassignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum Code {

    NO_DATA(HttpStatus.BAD_REQUEST, "데이터가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
