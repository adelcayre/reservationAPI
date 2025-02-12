package com.reservation.app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecordUpdateException extends RuntimeException {
    private final int code;

    public RecordUpdateException(final int code, final String message) {
        super(message);
        this.code = code;
    }

    public int getCodes() {
        return code;
    }

}
