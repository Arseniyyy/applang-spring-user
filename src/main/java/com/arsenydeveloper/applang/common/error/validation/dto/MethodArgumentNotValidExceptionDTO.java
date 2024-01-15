package com.arsenydeveloper.applang.common.error.validation.dto;

/**
 * Common model for responding with error messages
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class MethodArgumentNotValidExceptionDTO {

    private String target;
    private String defaultMessage;
    private int statusCode;
    private String path;

    /**
     * Constructs an ErrorUDTO with the specified error message and status code.
     * @param target The request body field where the exception has happened
     * @param defaultMessage The error message to be associated with the error.
     * @param statusCode   The HTTP status code to be associated with the error.
     */
    public MethodArgumentNotValidExceptionDTO(String target, String defaultMessage, int statusCode, String path) {
        this.target = target;
        this.defaultMessage = defaultMessage;
        this.statusCode = statusCode;
        this.path = path;
    }

    public String getTarget() {
        return target;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getPath() {
        return path;
    }
}