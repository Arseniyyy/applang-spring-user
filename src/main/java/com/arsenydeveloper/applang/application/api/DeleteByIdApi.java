package com.arsenydeveloper.applang.application.api;

import java.util.UUID;

/**
 * DeleteByIdApi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface DeleteByIdApi {

    void delete(UUID id);
}
