package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.api.FindByIdApi;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.FindByIdSpi;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

/**
 * FindByIdUseCase
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class FindByIdUseCase implements FindByIdApi {

    @Autowired
    private FindByIdSpi findByIdSpi;

    public FindByIdUseCase(FindByIdSpi findByIdSpi) {
        this.findByIdSpi = findByIdSpi;
    }

    @Override
    public UData findById(UUID id) {
        return this.findByIdSpi.findById(id);
    }
}
