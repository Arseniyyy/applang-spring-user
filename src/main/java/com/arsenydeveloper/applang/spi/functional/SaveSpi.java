package com.arsenydeveloper.applang.spi.functional;

import com.arsenydeveloper.applang.persistence.U;

/**
 * SaveSpi
 */
@FunctionalInterface
public interface SaveSpi {

    U save(U u);
}
