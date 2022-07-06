package cinema.controller;

import org.springframework.http.HttpStatus;


public class Error {
    private final HttpStatus status;
    private final String error;

    public Error(HttpStatus status, String error) {
        this.status = status;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
