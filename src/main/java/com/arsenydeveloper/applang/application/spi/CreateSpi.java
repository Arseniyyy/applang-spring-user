package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.domain.model.U;

/**
 * CreateSpi
 */
@FunctionalInterface
public interface CreateSpi {

    UData create(U u);
}
