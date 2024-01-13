package com.arsenydeveloper.applang.common.error.validation.response;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import com.arsenydeveloper.applang.common.error.validation.dto.NoResourceFoundExceptionDTO;

public class NoResourceFoundExceptionResponseEntity {

    public static NoResourceFoundExceptionDTO notFound(NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
        String message = getMessage(noResourceFoundException);
        String path = getPath(request);

        return new NoResourceFoundExceptionDTO(message, ErrorStatusCode.NOT_FOUND_404, path);
    }

    private static String getMessage(NoResourceFoundException noResourceFoundException) {
        return noResourceFoundException.getMessage();
    }

    private static String getPath(HttpServletRequest request) {
        return request.getServletPath();
    }
}
