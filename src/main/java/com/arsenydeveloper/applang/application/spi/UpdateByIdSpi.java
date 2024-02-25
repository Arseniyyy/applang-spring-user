package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;
import java.util.Map;

/**
 * UpdateByIdSpi
 */
@FunctionalInterface
public interface UpdateByIdSpi {

    UData update(UUID id, Map<String, Object> fields);
}
