package com.arsenydeveloper.applang.common.error.notfound.response;

import com.arsenydeveloper.applang.common.error.notfound.data.NoResourceFoundExceptionData;
import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

public class NoResourceFoundExceptionResponseEntity {

    public static NoResourceFoundExceptionData notFound(NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
        String message = getMessage(noResourceFoundException);
        String path = getPath(request);

        return new NoResourceFoundExceptionData(message, ErrorStatusCode.NOT_FOUND_404, path);
    }

    private static String getMessage(NoResourceFoundException noResourceFoundException) {
        return noResourceFoundException.getMessage();
    }

    private static String getPath(HttpServletRequest request) {
        return request.getServletPath();
    }
}
