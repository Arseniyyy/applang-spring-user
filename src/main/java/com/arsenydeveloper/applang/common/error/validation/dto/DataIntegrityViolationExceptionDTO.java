package com.arsenydeveloper.applang.common.error.validation.dto;

public class DataIntegrityViolationExceptionDTO {

    private String message;
    private String path;
    private int statusCode;

    public DataIntegrityViolationExceptionDTO(String message, String path, int statusCode) {
        this.message = message;
        this.path = path;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
