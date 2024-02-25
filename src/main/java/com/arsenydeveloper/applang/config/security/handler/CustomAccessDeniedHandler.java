package com.arsenydeveloper.applang.config.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class CustomAccessDeniedHandler implements AccessDeniedHandler, AuthenticationEntryPoint {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        String message = accessDeniedException.getMessage();
        String statusCode = "403";

        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        Map<String, String> exceptionMap = new HashMap<>();
        exceptionMap.put("error", "Forbidden");
        exceptionMap.put("message", message);
        exceptionMap.put("statusCode", statusCode);

        String errorMessageJson = new ObjectMapper().writeValueAsString(exceptionMap);

        response.getWriter().write(errorMessageJson);
        response.getWriter().flush();
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        String message = authException.getMessage();
        String statusCode = "401";

        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        Map<String, String> exceptionMap = new HashMap<>();
        exceptionMap.put("error", "Unauthorized");
        exceptionMap.put("message", message);
        exceptionMap.put("statusCode", statusCode);

        String errorMessageJson = new ObjectMapper().writeValueAsString(exceptionMap);

        response.getWriter().write(errorMessageJson);
        response.getWriter().flush();
    }
}
