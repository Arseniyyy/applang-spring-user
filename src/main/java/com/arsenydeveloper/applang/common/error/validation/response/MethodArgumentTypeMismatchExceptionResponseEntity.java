package com.arsenydeveloper.applang.common.error.validation.response;

import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import com.arsenydeveloper.applang.common.error.validation.data.MethodArgumentTypeMismatchExceptionData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * MethodArgumentTypeMismatchExceptionResponseEntity
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */

public class MethodArgumentTypeMismatchExceptionResponseEntity {

    /**
     * @param methodArgumentNotValidException {@code MethodArgumentTypeMismatchException}
     * @return {@code MethodArgumentNotValidExceptionDTO}
     */
    public static MethodArgumentTypeMismatchExceptionData badRequest(MethodArgumentTypeMismatchException methodArgumentNotValidException, HttpServletRequest request) {
        String value = getValue(methodArgumentNotValidException);
        String name = getName(methodArgumentNotValidException);
        String message = getMessage(methodArgumentNotValidException);
        String path = getPath(request);

        return new MethodArgumentTypeMismatchExceptionData(value, name, message, ErrorStatusCode.BAD_REQUEST_400, path);
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
