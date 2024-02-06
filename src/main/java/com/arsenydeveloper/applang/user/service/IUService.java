package com.arsenydeveloper.applang.user.service;

import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.arsenydeveloper.applang.user.persistence.U;

/**
 * IUService
 */
public interface IUService {

    List<U> findAll();

    U findById(UUID id);

    Optional<U> findByEmail(String email);

    U create(U u) throws IllegalStateException;

    U partialUpdate(UUID id, Map<String, Object> fields) throws IllegalStateException;

    void delete(UUID id);
}
