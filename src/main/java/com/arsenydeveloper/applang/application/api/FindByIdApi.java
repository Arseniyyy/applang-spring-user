package com.arsenydeveloper.applang.application.api;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;

/**
 * FindById
 */
@FunctionalInterface
public interface FindByIdApi {

    UData findById(UUID id);
}
