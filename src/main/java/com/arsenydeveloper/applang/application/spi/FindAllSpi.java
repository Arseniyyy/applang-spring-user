package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.List;

/**
 * FindAllSpi
 */
@FunctionalInterface
public interface FindAllSpi {

    List<UData> findAll();
}
