package com.arsenydeveloper.applang.user.controller;

import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.NoSuchElementException;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import com.arsenydeveloper.applang.user.persistence.U;
import com.arsenydeveloper.applang.user.persistence.dto.UDTO;
import com.arsenydeveloper.applang.user.service.UService;
import com.arsenydeveloper.applang.user.util.UUtils;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentNotValidExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.MethodArgumentTypeMismatchExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.NoResourceFoundExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.dto.NoSuchElementExceptionDTO;
import com.arsenydeveloper.applang.common.error.validation.response.MethodArgumentNotValidExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.MethodArgumentTypeMismatchExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.NoResourceFoundExceptionResponseEntity;
import com.arsenydeveloper.applang.common.error.validation.response.NoSuchElementExceptionResponseEntity;

/**
 * {@code RestController} for making requests to the `/u` endpoint.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@RestController
@RequestMapping(path = "/")
class UController {

    private final UService uService;
    private final UUtils uUtils;

    @Autowired
    public UController(UService uService, UUtils uUtils, Environment env) {
        this.uService = uService;
        this.uUtils = uUtils;
    }

    /**
     * Get all {@code U} instances.
     */
    @GetMapping(
        value = "${info.api.u-url}",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private List<UDTO> getAllU() {
        List<U> us = uService.findAll();
        List<UDTO> dtos = uUtils.convertToDTOMultiple(us);

        return dtos;
    }

    /**
     * Get a specific {@code U} instance.
     * @param id UUID of a specific U instance
     */
    @GetMapping(
        value = "${info.api.u-url}/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private UDTO getSpecificU(@PathVariable UUID id) {
        U u = uService.findSpecific(id);
        UDTO udto = uUtils.convertToDTO(u);

        return udto;
    }

    /**
     * Post a {@code U} instance.
     * @param requestBody Request body
     */
    @PostMapping(
        value = "${info.api.u-url}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private ResponseEntity<?> createU(@RequestBody @Valid U requestBody) {
        U createdEntity = uService.create(requestBody);
        UDTO uDTO =  uUtils.convertToDTO(createdEntity);

        return new ResponseEntity<>(uDTO, HttpStatus.CREATED);
    }

    /**
     * Patch a {@code U} instance.
     */
    @PatchMapping(
        value = "${info.api.u-url}/{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private ResponseEntity<UDTO> partialUpdateU(@PathVariable UUID id,  @RequestBody @Valid Map<String, Object> fields) {
        U updatedEntity = uService.partialUpdate(id, fields);
        UDTO uDTO = uUtils.convertToDTO(updatedEntity);

        return new ResponseEntity<>(uDTO, HttpStatus.OK);
    }

    /**
     * Delete a {@code U} instance.
     * @param id UUID of a specific U instance
     */
    @DeleteMapping(
        value = "${info.api.u-url}/{id}"
    )
    private ResponseEntity<Void> deleteU(@PathVariable UUID id) {
        uService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Handle {@code MethodArgumentNotValidException}
     * @param methodArgumentNotValidException instance of {@code MethodArgumentNotValidException}
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<MethodArgumentNotValidExceptionDTO> handleMethodArgumentNotValidException(
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
    private ResponseEntity<MethodArgumentTypeMismatchExceptionDTO> handleMethodArgumentTypeMismatchException(
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
    private ResponseEntity<NoSuchElementExceptionDTO> handleNoSuchElementException(NoSuchElementException noSuchElementException, HttpServletRequest request) {
        NoSuchElementExceptionDTO noSuchElementExceptionDTO = NoSuchElementExceptionResponseEntity.notFound(noSuchElementException, request);
        return new ResponseEntity<>(noSuchElementExceptionDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle {@code NoResourceFoundException}
     * @param noResourceFoundException
     * @return {@code ResponseEntity<NoResourceFoundException>}
     */
    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity<NoResourceFoundExceptionDTO> handleNoResourceFoundException(NoResourceFoundException noResourceFoundException, HttpServletRequest request) {
        NoResourceFoundExceptionDTO noResourceFoundExceptionDTO = NoResourceFoundExceptionResponseEntity.notFound(noResourceFoundException, request);

        return new ResponseEntity<>(noResourceFoundExceptionDTO, HttpStatus.NOT_FOUND);
    }
}
