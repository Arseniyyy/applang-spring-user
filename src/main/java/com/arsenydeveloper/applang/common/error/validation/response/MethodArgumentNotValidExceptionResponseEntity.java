package com.arsenydeveloper.applang.common.error.validation.response;

import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentNotValidExceptionDTO;
import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;

/**
 * Error response class provides several methods for creating
 * {@code ResponseEntity} instances with various status codes and messages.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class MethodArgumentNotValidExceptionResponseEntity {

    /**
     * @param methodArgumentNotValidException MethodArgumentNotValidException
     * @return {@code MethodArgumentNotValidExceptionDTO} ResponseEntity instance that accepts MethodArgumentNotValidExceptionDTO as a type
     */
    public static MethodArgumentNotValidExceptionDTO badRequest(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request) {
        String target = getTarget(methodArgumentNotValidException);
        String errorMessage = getDefaultMessage(methodArgumentNotValidException);
        String path = getPath(request);

        MethodArgumentNotValidExceptionDTO badRequestBodyErrorDTO = new MethodArgumentNotValidExceptionDTO(
                target, errorMessage, ErrorStatusCode.BAD_REQUEST_400, path);

        return badRequestBodyErrorDTO;
    }

    /**
     * Get field name that has been violated
     * @param constraintViolation ConstraintViolation instance
     * @return {@code String} name of the field
     */
    private static String getTarget(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getTarget().toString();
    }

    /**
     * Get error message of request body
     * @param constraintViolation ConstraintViolation instance
     * @return {@code MethodArgumentNotValidExceptionDTO} ResponseEntity instance that accepts MethodArgumentNotValidExceptionDTO as a type
     */
    private static String getDefaultMessage(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getFieldError().getDefaultMessage();
    }

    /**
     *
     */
    private static String getPath(HttpServletRequest request) {
        return request.getServletPath();
    }
}
