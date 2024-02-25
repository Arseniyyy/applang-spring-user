package com.arsenydeveloper.applang.application.api;

import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.domain.model.U;

/**
 * CreateApi
 */
@FunctionalInterface
public interface CreateApi {

    UData create(U u);
}
