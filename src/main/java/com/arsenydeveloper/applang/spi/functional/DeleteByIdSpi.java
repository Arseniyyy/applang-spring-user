package com.arsenydeveloper.applang.spi.functional;

import java.util.UUID;

/**
 * DeleteByIdApi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface DeleteByIdSpi {

    void deleteById(UUID id);
}

