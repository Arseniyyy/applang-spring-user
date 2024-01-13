package com.arsenydeveloper.applang.common.error.validation.dto;

public class MethodArgumentTypeMismatchExceptionDTO {

    private String value;
    private String name;
    private String message;
    private int statusCode;
    private String path;

    public MethodArgumentTypeMismatchExceptionDTO(String value, String name, String message, int statusCode, String path) {
        this.value = value;
        this.name = name;
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
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
