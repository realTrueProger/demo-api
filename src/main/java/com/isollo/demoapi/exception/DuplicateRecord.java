package com.isollo.demoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateRecord extends RuntimeException {
    public DuplicateRecord(String message) {
        super(message);
    }
}
