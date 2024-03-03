package com.arsenydeveloper.applang.application.api;

import com.arsenydeveloper.applang.application.data.UData;
import java.util.List;

/**
 * FindAllApi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface FindAllApi {

    List<UData> findAll();
}
