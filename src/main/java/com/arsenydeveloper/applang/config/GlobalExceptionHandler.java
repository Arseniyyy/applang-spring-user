package com.arsenydeveloper.applang.config;

import java.util.NoSuchElementException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import com.arsenydeveloper.applang.common.error.validation.dto.NoResourceFoundExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.NoSuchElementExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentNotValidExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentTypeMismatchExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.response.NoResourceFoundExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.MethodArgumentNotValidExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.MethodArgumentTypeMismatchExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.NoSuchElementExceptionResponseEntity;

/**
 * GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle {@code NoResourceFoundException}
     * @param noResourceFoundException
     * @return {@code ResponseEntity<NoResourceFoundException>}
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<NoResourceFoundExceptionDTO> handleNoResourceFoundException(NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
        NoResourceFoundExceptionDTO noResourceFoundExceptionDTO = NoResourceFoundExceptionResponseEntity.notFound(noResourceFoundException, request);

        return new ResponseEntity<>(noResourceFoundExceptionDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle {@code MethodArgumentNotValidException}
     * @param methodArgumentNotValidException instance of {@code MethodArgumentNotValidException}
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidExceptionDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException,
            HttpServletRequest request
    ) {
        MethodArgumentNotValidExceptionDTO badRequestBodyErrorDTO = MethodArgumentNotValidExceptionResponseEntity.badRequest(
                methodArgumentNotValidException, request);

        return ResponseEntity.badRequest().body(badRequestBodyErrorDTO);
    }

    /**
     * Handle {@code MethodArgumentTypeMismatchException}
     * @param methodArgumentTypeMismatchException MethodArgumentTypeMismatchException
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MethodArgumentTypeMismatchExceptionDTO> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException methodArgumentTypeMismatchException,
            HttpServletRequest request)
    {
        MethodArgumentTypeMismatchExceptionDTO methodArgumentTypeMismatchExceptionDTO = MethodArgumentTypeMismatchExceptionResponseEntity.badRequest(
                methodArgumentTypeMismatchException, request);
        return ResponseEntity.badRequest().body(methodArgumentTypeMismatchExceptionDTO);
    }

    /**
     * Handle {@code NoSuchElementException}
     * @param noSuchElementException An instance of {@code NoSuchElementException}
     * @param request An instance of {@code HttpServletRequest}
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<NoSuchElementExceptionDTO> handleNoSuchElementException(NoSuchElementException noSuchElementException, HttpServletRequest request) {
        NoSuchElementExceptionDTO noSuchElementExceptionDTO = NoSuchElementExceptionResponseEntity.notFound(noSuchElementException, request);
        return new ResponseEntity<>(noSuchElementExceptionDTO, HttpStatus.NOT_FOUND);
    }
}
