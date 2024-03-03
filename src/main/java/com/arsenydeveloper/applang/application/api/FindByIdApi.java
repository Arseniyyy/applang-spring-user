package com.arsenydeveloper.applang.application.api;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;

/**
 * FindById
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface FindByIdApi {

    UData findById(UUID id);
}
