package com.arsenydeveloper.applang.api.functional;

import java.util.UUID;

/**
 * DeleteByIdApi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface DeleteByIdApi {

    void deleteById(UUID id);
}
