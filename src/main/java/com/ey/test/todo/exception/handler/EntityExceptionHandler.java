package com.ey.test.todo.exception.handler;

import com.ey.test.todo.exception.InvalidFieldException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidFieldException.class)
    String handleInvalidFieldException(InvalidFieldException invalidFieldException) {
        return invalidFieldException.getMessage();
    }
}
