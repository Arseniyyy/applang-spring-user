package com.arsenydeveloper.applang.application.api;

import com.arsenydeveloper.applang.application.data.UData;

import java.util.Map;
import java.util.UUID;

/**
 * UpdateByIdApi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface UpdateByIdApi {

    UData update(UUID id, Map<String, Object> fields);
}
