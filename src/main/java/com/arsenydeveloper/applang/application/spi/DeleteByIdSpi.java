package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;

/**
 * DeleteByIdSpi
 */
@FunctionalInterface
public interface DeleteByIdSpi {

    void delete(UUID id);
}

