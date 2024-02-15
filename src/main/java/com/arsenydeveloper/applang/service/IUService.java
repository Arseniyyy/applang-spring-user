package com.arsenydeveloper.applang.service;

import com.arsenydeveloper.applang.persistence.U;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * IUService is an interface for {@code UService}
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public interface IUService {

    List<U> findAll();

    U findById(UUID id);

    Optional<U> findByEmail(String email);

    U create(U u) throws IllegalStateException;

    U partialUpdate(UUID id, Map<String, Object> fields) throws IllegalStateException;

    void delete(UUID id);
}
