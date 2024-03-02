package com.arsenydeveloper.applang.application.api;

import java.util.UUID;

/**
 * DeleteByIdApi
 */
@FunctionalInterface
public interface DeleteByIdApi {

    void delete(UUID id);
}
