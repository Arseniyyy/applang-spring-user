package com.arsenydeveloper.applang.common.error.validation.response;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentTypeMismatchExceptionDTO;

import jakarta.servlet.http.HttpServletRequest;

public class MethodArgumentTypeMismatchExceptionResponseEntity {

    /**
     * @param methodArgumentNotValidException {@code MethodArgumentTypeMismatchException}
     * @return {@code MethodArgumentNotValidExceptionDTO}
     */
    public static MethodArgumentTypeMismatchExceptionDTO badRequest(MethodArgumentTypeMismatchException methodArgumentNotValidException, HttpServletRequest request) {
        String value = getValue(methodArgumentNotValidException);
        String name = getName(methodArgumentNotValidException);
        String message = getMessage(methodArgumentNotValidException);
        String path = getPath(request);

        return new MethodArgumentTypeMismatchExceptionDTO(value, name, message, ErrorStatusCode.BAD_REQUEST_400, path);
    }

    private static String getValue(MethodArgumentTypeMismatchException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getValue().toString();
    }

    private static String getName(MethodArgumentTypeMismatchException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getName();
    }

    private static String getMessage(MethodArgumentTypeMismatchException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getMessage();
    }

    private static String getPath(HttpServletRequest request) {
        return request.getServletPath();
    }
}
