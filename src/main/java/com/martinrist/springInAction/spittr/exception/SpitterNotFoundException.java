package com.martinrist.springInAction.spittr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Spitter not found")
public class SpitterNotFoundException extends RuntimeException {
    public SpitterNotFoundException(String message) {
        super(message);
    }
}
