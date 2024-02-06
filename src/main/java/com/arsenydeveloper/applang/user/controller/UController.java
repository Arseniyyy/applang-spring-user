package com.arsenydeveloper.applang.user.controller;

import java.util.List;
import java.util.UUID;
import java.util.Map;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.arsenydeveloper.applang.user.persistence.U;
import com.arsenydeveloper.applang.user.persistence.dto.UDTO;
import com.arsenydeveloper.applang.user.service.IUService;
import com.arsenydeveloper.applang.user.util.UUtils;

/**
 * {@code RestController} for making requests to the `/u` endpoint.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@RestController
@RequestMapping
class UController {

    private final IUService uService;
    private final UUtils uUtils;

    @Autowired
    public UController(IUService uService, UUtils uUtils) {
        this.uService = uService;
        this.uUtils = uUtils;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(
        value = "${info.api.u-url}",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<UDTO>> getAllU() {
        List<U> us = uService.findAll();
        List<UDTO> uDTOs = uUtils.convertToDTOMultiple(us);

        return ResponseEntity.ok().body(uDTOs);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(
        value = "${info.api.u-url}/{id}",
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UDTO> getSpecificU(@PathVariable UUID id) {
        U u = uService.findById(id);
        UDTO udto = uUtils.convertToDTO(u);

        return ResponseEntity.ok().body(udto);
    }

    @PostMapping(
        value = "${info.api.u-url}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<?> createU(@RequestBody @Valid U requestBody) {
        U createdEntity = uService.create(requestBody);
        UDTO uDTO =  uUtils.convertToDTO(createdEntity);

        return new ResponseEntity<>(uDTO, HttpStatus.CREATED);
    }

    @PatchMapping(
        value = "${info.api.u-url}/{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UDTO> partialUpdateU(@PathVariable UUID id,  @RequestBody @Valid Map<String, Object> fields) {
        U updatedEntity = uService.partialUpdate(id, fields);
        UDTO uDTO = uUtils.convertToDTO(updatedEntity);

        return ResponseEntity.ok().body(uDTO);
    }

    @DeleteMapping(
        value = "${info.api.u-url}/{id}"
    )
    public ResponseEntity<Void> deleteU(@PathVariable UUID id) {
        uService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
