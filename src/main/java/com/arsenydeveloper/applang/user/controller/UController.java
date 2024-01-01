package com.arsenydeveloper.applang.user.controller;

import java.util.List;
import java.util.UUID;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import com.arsenydeveloper.applang.user.model.U;
import com.arsenydeveloper.applang.user.model.dto.UDTO;
import com.arsenydeveloper.applang.user.service.UService;

/**
 * <code>RestController</code> for making requests to the `/u` endpoint.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@RestController
@RequestMapping(path = "${info.api.u-url}")
public class UController {

    private final UService uService;
    private final UUtils uUtils;

    @Autowired
    public UController(UService uService, UUtils uUtils, Environment env) {
        this.uService = uService;
        this.uUtils = uUtils;
    }

    /**
     * Get all <code>U</code> instances.
     */
    @GetMapping(
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private List<UDTO> getAllU() {
        List<U> us = uService.findAll();
        List<UDTO> dtos = uUtils.convertToDTOMultiple(us);

        return dtos;
    }

    /**
     * Get a specific <code>U</code> instance.
     */
    @GetMapping(
        value = "{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private UDTO getSpecificU(@PathVariable UUID id) {
        U u = uService.findSpecific(id);
        UDTO udto = uUtils.convertToDTO(u);

        return udto;
    }

    /**
     * Post a <code>U</code> instance.
     */
    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private ResponseEntity<UDTO> createU(@RequestBody U requestBody) {
        U createdEntity = uService.create(requestBody);
        UDTO uDTO =  uUtils.convertToDTO(createdEntity);

        return new ResponseEntity<>(uDTO, HttpStatus.CREATED);
    }

    /**
     * Patch a <code>U</code> instance.
     */
    @PatchMapping(
        value = "{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    private ResponseEntity<UDTO> partialUpdateU(@PathVariable UUID id,  @RequestBody Map<String, Object> fields) {
        U updatedEntity = uService.partialUpdate(id, fields);
        UDTO uDTO = uUtils.convertToDTO(updatedEntity);

        return new ResponseEntity<>(uDTO, HttpStatus.OK);
    }

    /**
     * Delete a <code>U</code> instance.
     */
    @DeleteMapping("{id}")
    private ResponseEntity<Void> deleteU(@PathVariable UUID id) {
        uService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
