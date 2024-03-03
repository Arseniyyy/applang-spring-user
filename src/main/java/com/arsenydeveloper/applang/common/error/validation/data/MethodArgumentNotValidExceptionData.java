package com.arsenydeveloper.applang.common.error.validation.data;

/**
 * MethodArgumentNotValidExceptionData. Common model for responding with error messages
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class MethodArgumentNotValidExceptionData {

    private String field;
    private String defaultMessage;
    private int statusCode;
    private String path;

    /**
     * Constructs an ErrorUDTO with the specified error message and status code.
     * @param field The request body field where the exception has happened
     * @param defaultMessage The error message to be associated with the error.
     * @param statusCode   The HTTP status code to be associated with the error.
     */
    public MethodArgumentNotValidExceptionData(String field, String defaultMessage, int statusCode, String path) {
        this.field = field;
        this.defaultMessage = defaultMessage;
        this.statusCode = statusCode;
        this.path = path;
    }

    public String getField() {
        return field;
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
