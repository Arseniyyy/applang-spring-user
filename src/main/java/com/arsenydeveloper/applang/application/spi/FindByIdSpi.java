package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;

/**
 * FindByIdSpi
 */
@FunctionalInterface
public interface FindByIdSpi {

    UData findById(UUID id);
}
