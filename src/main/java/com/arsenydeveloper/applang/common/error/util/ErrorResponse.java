package com.arsenydeveloper.applang.common.error.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.arsenydeveloper.applang.common.error.dto.ErrorUDTO;
import com.arsenydeveloper.applang.common.error.message.ErrorMessage;

/**
 * Error response class provides several methods for creating
 * {@code ResponseEntity} instances with various status codes and messages.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class ErrorResponse {

    /**
     * @param bindingResult BindingResult instance
     * @return {@code ErrorUDTO} ResponseEntity instance that accepts ErrorUDTO as a type
     */
    public static ErrorUDTO badRequest(BindingResult bindingResult) {
        String errorMessage = getErrorMessage(bindingResult);
        ErrorUDTO errorUDTO = new ErrorUDTO(errorMessage, ErrorMessage.BAD_REQUEST_400);

        return errorUDTO;
    }

    /**
     * @param bindingResult BindingResult instance
     * @return {@code ErrorUDTO} ResponseEntity instance that accepts ErrorUDTO as a type
     */
    public static ErrorUDTO unauthorized(BindingResult bindingResult) {
        String errorMessage = getErrorMessage(bindingResult);
        ErrorUDTO errorUDTO = new ErrorUDTO(errorMessage, ErrorMessage.UNAUTHORIZED_401);

        return errorUDTO;
    }

    /**
     * @param bindingResult BindingResult instance
     * @return {@code ErrorUDTO} ResponseEntity instance that accepts ErrorUDTO as a type
     */
    public static ErrorUDTO paymentRequired(BindingResult bindingResult) {
        String errorMessage = getErrorMessage(bindingResult);
        ErrorUDTO errorUDTO = new ErrorUDTO(errorMessage, ErrorMessage.PAYMENT_REQURIED_402);

        return errorUDTO;
    }

    /**
     * @param bindingResult BindingResult instance
     * @return {@code ErrorUDTO} ResponseEntity instance that accepts ErrorUDTO as a type
     */
    public static ErrorUDTO forbidden(BindingResult bindingResult) {
        String errorMessage = getErrorMessage(bindingResult);
        ErrorUDTO errorUDTO = new ErrorUDTO(errorMessage, ErrorMessage.FORBIDDEN_403);

        return errorUDTO;
    }

    /**
     * @param bindingResult BindingResult instance
     * @return {@code ErrorUDTO} ResponseEntity instance that accepts ErrorUDTO as a type
     */
    public static ErrorUDTO notFound(BindingResult bindingResult) {
        String errorMessage = getErrorMessage(bindingResult);
        ErrorUDTO errorUDTO = new ErrorUDTO(errorMessage, ErrorMessage.NOT_FOUND_404);

        return errorUDTO;
    }

    /**
     * @param bindingResult BindingResult instance
     * @return {@code ErrorUDTO} ResponseEntity instance that accepts ErrorUDTO as a type
     */
    public static ErrorUDTO unsupportedMediaType(BindingResult bindingResult) {
        String errorMessage = getErrorMessage(bindingResult);
        ErrorUDTO errorUDTO = new ErrorUDTO(errorMessage, ErrorMessage.UNSUPPORTED_MEDIA_TYPE_415);

        return errorUDTO;
    }

    /**
     * @param bindingResult BindingResult instance
     * @return {@code ErrorUDTO} ResponseEntity instance that accepts ErrorUDTO as a type
     */
    private static String getErrorMessage(BindingResult bindingResult) {
        FieldError firstError = bindingResult.getFieldErrors().get(0);
        String errorMessage = firstError.getDefaultMessage();

        return errorMessage;
    }
}
