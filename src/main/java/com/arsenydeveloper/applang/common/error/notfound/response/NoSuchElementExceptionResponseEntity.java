package com.arsenydeveloper.applang.common.error.notfound.response;

import com.arsenydeveloper.applang.common.error.notfound.dto.NoSuchElementExceptionDTO;
import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import jakarta.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

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
