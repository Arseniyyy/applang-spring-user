package com.arsenydeveloper.applang.common.error.validation.response;

import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import com.arsenydeveloper.applang.common.error.validation.data.MethodArgumentNotValidExceptionData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Return {@code MethodArgumentNotValidExceptionData} as a {@code ResponseEntity}
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class MethodArgumentNotValidExceptionResponseEntity {

    public static MethodArgumentNotValidExceptionData badRequest(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request) {
        String field = getField(methodArgumentNotValidException);
        String errorMessage = getDefaultMessage(methodArgumentNotValidException);
        String path = getPath(request);

        return new MethodArgumentNotValidExceptionData(
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
