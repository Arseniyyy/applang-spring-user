package com.arsenydeveloper.applang.common.error.validation.response;

import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentNotValidExceptionDTO;
import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;

/**
 * Return {@code MethodArgumentNotValidExceptionDTO} as a {@code ResponseEntity}
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class MethodArgumentNotValidExceptionResponseEntity {

    public static MethodArgumentNotValidExceptionDTO badRequest(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request) {
        String field = getField(methodArgumentNotValidException);
        String errorMessage = getDefaultMessage(methodArgumentNotValidException);
        String path = getPath(request);

        return new MethodArgumentNotValidExceptionDTO(
                field, errorMessage, ErrorStatusCode.BAD_REQUEST_400, path);
    }

    /**
     * Get field name that has been violated
     * @param constraintViolation ConstraintViolation instance
     * @return {@code String} name of the field
     */
    private static String getField(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getFieldError().getField();
    }

    private static String getDefaultMessage(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getFieldError().getDefaultMessage();
    }

    private static String getPath(HttpServletRequest request) {
        return request.getServletPath();
    }
}
