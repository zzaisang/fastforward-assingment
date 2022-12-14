package com.example.fastforwardassignment.exception;

import com.example.fastforwardassignment.domain.Code;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final Code code;

    public ApiException(Code code) {
        super(code.getMessage());
        this.code = code;
    }

    public ApiException(Code code, String message) {
        super(message);
        this.code = code;
    }
}
