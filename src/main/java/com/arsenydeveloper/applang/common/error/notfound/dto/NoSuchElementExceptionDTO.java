package com.arsenydeveloper.applang.common.error.notfound.dto;

public class NoSuchElementExceptionDTO {
    private String message;
    private int statusCode;
    private String path;

    public NoSuchElementExceptionDTO(String message, int statusCode, String path) {
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getPath() {
        return path;
    }
}
