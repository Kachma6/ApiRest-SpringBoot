package com.diplomado.ApiRestSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RecurseAlreadyExistsException extends RuntimeException {
    public RecurseAlreadyExistsException(String massage) {
        super(massage);
    }
}
