package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;

/**
 * FindByIdSpi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface FindByIdSpi {

    UData findById(UUID id);
}
