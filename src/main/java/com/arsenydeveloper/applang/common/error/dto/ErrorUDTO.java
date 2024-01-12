package com.arsenydeveloper.applang.common.error.dto;

/**
 * Common model for responding with error messages
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class ErrorUDTO {

    private String errorMessage;
    private int statusCode;

    /**
     * Constructs an ErrorUDTO with the specified error message and status code.
     *
     * @param errorMessage The error message to be associated with the error.
     * @param statusCode   The HTTP status code to be associated with the error.
     */
    public ErrorUDTO(String errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    public String getError() {
        return errorMessage;
    }

    public int getStatus() {
        return statusCode;
    }
}
