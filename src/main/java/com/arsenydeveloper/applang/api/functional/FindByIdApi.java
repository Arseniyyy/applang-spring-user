package com.arsenydeveloper.applang.api.functional;

import com.arsenydeveloper.applang.persistence.U;
import java.util.Optional;
import java.util.UUID;

/**
 * FindByIdApi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface FindByIdApi {

    Optional<U> findById(UUID id);
}

