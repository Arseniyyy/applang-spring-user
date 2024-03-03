package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;

/**
 * DeleteByIdSpi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface DeleteByIdSpi {

    void delete(UUID id);
}
