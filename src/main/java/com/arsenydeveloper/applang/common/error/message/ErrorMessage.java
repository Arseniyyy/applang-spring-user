package com.arsenydeveloper.applang.common.error.message;

/**
 * ErrorMessage represents error messages which can be provided when something crashes.
 * Each value shows an error's message and its status code.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class ErrorMessage {

    public static final int BAD_REQUEST_400 = 400;
    public static final int UNAUTHORIZED_401 = 401;
    public static final int PAYMENT_REQURIED_402 = 402;
    public static final int FORBIDDEN_403 = 403;
    public static final int NOT_FOUND_404 = 404;
    public static final int UNSUPPORTED_MEDIA_TYPE_415 = 415;
}
