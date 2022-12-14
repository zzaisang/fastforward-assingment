package com.example.fastforwardassignment.exception;

import com.example.fastforwardassignment.domain.Code;
import com.example.fastforwardassignment.domain.common.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException e) {
        Code errorCode = e.getCode();
        String errorMessage = Arrays.stream(e.getStackTrace())
                .map(StackTraceElement::toString)
                .limit(7)
                .collect(Collectors.joining("\n"));
        log.error(errorMessage);
        return ResponseEntity.status(errorCode.getHttpStatus()).body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        log.error("error : {0}", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(v -> v.getField() + " : " + v.getDefaultMessage())
                .collect(Collectors.joining(", "));
        log.error("handleMethodArgumentNotValidException : {0}", ex);

        return ResponseEntity.badRequest().body(new ErrorResponse(errorMessage));
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(RuntimeException e) {
        String errorMessage = Arrays.stream(e.getStackTrace())
                .map(StackTraceElement::toString)
                .limit(7)
                .collect(Collectors.joining("\n"));
        log.error(errorMessage);
        return ResponseEntity.internalServerError().body(new ErrorResponse(errorMessage));
    }
}
