package com.arsenydeveloper.applang.common.error.validation.data;

/**
 * DataIntegrityViolationExceptionData
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class DataIntegrityViolationExceptionData {

    private String message;
    private String path;
    private int statusCode;

    public DataIntegrityViolationExceptionData(String message, String path, int statusCode) {
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
