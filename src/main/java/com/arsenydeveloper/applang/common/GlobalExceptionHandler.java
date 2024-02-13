package com.arsenydeveloper.applang.common;

import com.arsenydeveloper.applang.common.error.notfound.dto.NoResourceFoundExceptionDTO;
import com.arsenydeveloper.applang.common.error.notfound.dto.NoSuchElementExceptionDTO;
import com.arsenydeveloper.applang.common.error.notfound.response.NoResourceFoundExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.notfound.response.NoSuchElementExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.dto.DataIntegrityViolationExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentNotValidExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentTypeMismatchExceptionDTO;
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
    public ResponseEntity<NoResourceFoundExceptionDTO> handleNoResourceFoundException(NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
        NoResourceFoundExceptionDTO noResourceFoundExceptionDTO = NoResourceFoundExceptionResponseEntity.notFound(noResourceFoundException, request);

        return new ResponseEntity<>(noResourceFoundExceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<NoSuchElementExceptionDTO> handleNoSuchElementException(NoSuchElementException noSuchElementException, HttpServletRequest request) {
        NoSuchElementExceptionDTO noSuchElementExceptionDTO = NoSuchElementExceptionResponseEntity.notFound(noSuchElementException, request);

        return new ResponseEntity<>(noSuchElementExceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidExceptionDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException,
            HttpServletRequest request
    ) {
        System.out.println("OUTPUT: " + methodArgumentNotValidException.getFieldError().getField());
        MethodArgumentNotValidExceptionDTO methodArgumentNotValidExceptionDTO =
            MethodArgumentNotValidExceptionResponseEntity.badRequest(methodArgumentNotValidException, request);

        return ResponseEntity.badRequest().body(methodArgumentNotValidExceptionDTO);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MethodArgumentTypeMismatchExceptionDTO> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException methodArgumentTypeMismatchException,
            HttpServletRequest request
    )
    {
        MethodArgumentTypeMismatchExceptionDTO methodArgumentTypeMismatchExceptionDTO = MethodArgumentTypeMismatchExceptionResponseEntity.badRequest(
                methodArgumentTypeMismatchException, request);

        return ResponseEntity.badRequest().body(methodArgumentTypeMismatchExceptionDTO);
    }

    // Less specific errors
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DataIntegrityViolationExceptionDTO> handleDataIntegrityViolationException(
        DataIntegrityViolationException dataIntegrityViolationException,
        HttpServletRequest request
    )
    {
        DataIntegrityViolationExceptionDTO dataIntegrityViolationExceptionDTO = DataIntegrityViolationExceptionResponseEntity.badRequest(
                dataIntegrityViolationException, request);

        return ResponseEntity.badRequest().body(dataIntegrityViolationExceptionDTO);
    }
}
