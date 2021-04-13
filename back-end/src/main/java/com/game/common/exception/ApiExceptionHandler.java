package com.game.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request)
    {
        return new ErrorMessage(500, ex.getLocalizedMessage());
    }
    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorMessage> apiException(APIException e , WebRequest request)
    {
        return ResponseEntity.ok(ErrorMessage.fromException(e));
    }

}
