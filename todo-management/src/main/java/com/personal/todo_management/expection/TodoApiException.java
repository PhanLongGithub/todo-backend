package com.personal.todo_management.expection;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

}
