package com.arsenydeveloper.applang.common.error.notfound.data;

/**
 * NoResourceFoundExceptionData
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */

public class NoResourceFoundExceptionData {

    private String message;
    private int statusCode;
    private String path;

    public NoResourceFoundExceptionData(String message, int statusCode, String path) {
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
