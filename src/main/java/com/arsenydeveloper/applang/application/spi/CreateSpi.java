package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.domain.model.U;

/**
 * CreateSpi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface CreateSpi {

    UData create(U u);
}
