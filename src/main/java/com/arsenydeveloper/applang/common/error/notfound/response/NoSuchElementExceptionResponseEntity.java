package com.arsenydeveloper.applang.common.error.notfound.response;

import java.util.NoSuchElementException;
import jakarta.servlet.http.HttpServletRequest;

import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import com.arsenydeveloper.applang.common.error.notfound.dto.NoSuchElementExceptionDTO;

public class NoSuchElementExceptionResponseEntity {

    public static NoSuchElementExceptionDTO notFound(NoSuchElementException noSuchElementException, HttpServletRequest request) {
        String message = getMessage(noSuchElementException);
        String path = getPath(request);

        return new NoSuchElementExceptionDTO(message, ErrorStatusCode.NOT_FOUND_404, path);
    }

    private static String getMessage(NoSuchElementException noSuchElementException) {
        return noSuchElementException.getMessage();
    }

    private static String getPath(HttpServletRequest request) {
        return request.getServletPath();
    }
}
