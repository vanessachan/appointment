package com.agenda.exception;

import com.agenda.exception.ErrorMessage;
import com.agenda.exception.NotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

//    @ExceptionHandler(value={Exception.class})
//    @ResponseStatus(value = HttpStatus.)
//    public ErrorMessage handleConflict(Exception ex, WebRequest request) {
//        return new ErrorMessage(HttpStatus.CONFLICT.value(), LocalDateTime.now(), ex.getMessage(), request.getDescription(true));
//    }

    @ExceptionHandler(value={NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage handleNotFound(RuntimeException ex, WebRequest request) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), "Element not found", request.getDescription(true));
    }
}
