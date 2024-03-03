package com.arsenydeveloper.applang.application.spi;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.List;

/**
 * FindAllSpi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface FindAllSpi {

    List<UData> findAll();
}
