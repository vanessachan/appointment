package com.agenda.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private LocalDateTime date;
    private String message;
    private String description;

}
