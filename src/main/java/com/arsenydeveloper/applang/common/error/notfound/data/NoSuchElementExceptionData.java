package com.arsenydeveloper.applang.common.error.notfound.data;

/**
 * NoSuchElementExceptionData
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */

public class NoSuchElementExceptionData {
    private String message;
    private int statusCode;
    private String path;

    public NoSuchElementExceptionData(String message, int statusCode, String path) {
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
