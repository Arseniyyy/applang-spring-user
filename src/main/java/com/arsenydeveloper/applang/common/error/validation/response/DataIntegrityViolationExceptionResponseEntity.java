package com.arsenydeveloper.applang.common.error.validation.response;

import com.arsenydeveloper.applang.common.error.util.ErrorStatusCode;
import com.arsenydeveloper.applang.common.error.validation.data.DataIntegrityViolationExceptionData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;


public class DataIntegrityViolationExceptionResponseEntity {

    public static DataIntegrityViolationExceptionData badRequest(
        DataIntegrityViolationException dataIntegrityViolationException,
        HttpServletRequest request
    )
    {
        String message = getMessage(dataIntegrityViolationException);
        String path = getPath(request);
        int statusCode = getStatusCode();

        return new DataIntegrityViolationExceptionData(message, path, statusCode);
    }

    private static String getMessage(DataIntegrityViolationException dataIntegrityViolationException) {
        return dataIntegrityViolationException.getCause().getCause().getMessage();
    }

    private static String getPath(HttpServletRequest request) {
        return request.getServletPath();
    }

    private static int getStatusCode() {
        return ErrorStatusCode.BAD_REQUEST_400;
    }
}
