package com.arsenydeveloper.applang.common.error.notfound.dto;

public class NoResourceFoundExceptionDTO {

    private String message;
    private int statusCode;
    private String path;

    public NoResourceFoundExceptionDTO(String message, int statusCode, String path) {
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
