package com.arsenydeveloper.applang.common;

import com.arsenydeveloper.applang.common.error.notfound.data.NoResourceFoundExceptionData;
import com.arsenydeveloper.applang.common.error.notfound.data.NoSuchElementExceptionData;
import com.arsenydeveloper.applang.common.error.notfound.response.NoResourceFoundExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.notfound.response.NoSuchElementExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.data.DataIntegrityViolationExceptionData;
import com.arsenydeveloper.applang.common.error.validation.data.MethodArgumentNotValidExceptionData;
import com.arsenydeveloper.applang.common.error.validation.data.MethodArgumentTypeMismatchExceptionData;
import com.arsenydeveloper.applang.common.error.validation.response.DataIntegrityViolationExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.MethodArgumentNotValidExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.MethodArgumentTypeMismatchExceptionResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<NoResourceFoundExceptionData> handleNoResourceFoundException(NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
        NoResourceFoundExceptionData noResourceFoundExceptionData = NoResourceFoundExceptionResponseEntity.notFound(noResourceFoundException, request);

        return new ResponseEntity<>(noResourceFoundExceptionData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<NoSuchElementExceptionData> handleNoSuchElementException(NoSuchElementException noSuchElementException, HttpServletRequest request) {
        NoSuchElementExceptionData noSuchElementExceptionData = NoSuchElementExceptionResponseEntity.notFound(noSuchElementException, request);

        return new ResponseEntity<>(noSuchElementExceptionData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidExceptionData> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException,
            HttpServletRequest request
    ) {
        System.out.println("OUTPUT: " + methodArgumentNotValidException.getFieldError().getField());
        MethodArgumentNotValidExceptionData methodArgumentNotValidExceptionData =
            MethodArgumentNotValidExceptionResponseEntity.badRequest(methodArgumentNotValidException, request);

        return ResponseEntity.badRequest().body(methodArgumentNotValidExceptionData);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MethodArgumentTypeMismatchExceptionData> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException methodArgumentTypeMismatchException,
            HttpServletRequest request
    )
    {
        MethodArgumentTypeMismatchExceptionData methodArgumentTypeMismatchExceptionData = MethodArgumentTypeMismatchExceptionResponseEntity.badRequest(
                methodArgumentTypeMismatchException, request);

        return ResponseEntity.badRequest().body(methodArgumentTypeMismatchExceptionData);
    }

    // Less specific errors
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DataIntegrityViolationExceptionData> handleDataIntegrityViolationException(
        DataIntegrityViolationException dataIntegrityViolationException,
        HttpServletRequest request
    )
    {
        DataIntegrityViolationExceptionData dataIntegrityViolationExceptionData = DataIntegrityViolationExceptionResponseEntity.badRequest(
                dataIntegrityViolationException, request);

        return ResponseEntity.badRequest().body(dataIntegrityViolationExceptionData);
    }
}
