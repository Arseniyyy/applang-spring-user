package com.arsenydeveloper.applang.application.api;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.UUID;

/**
 * DeleteByIdApi
 */
@FunctionalInterface
public interface DeleteByIdApi {

    void delete(UUID id);
}
