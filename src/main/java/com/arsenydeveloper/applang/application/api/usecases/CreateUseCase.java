package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.api.CreateApi;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.CreateSpi;
import com.arsenydeveloper.applang.domain.model.U;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CreateUseCase
 */
public class CreateUseCase implements CreateApi {

    @Autowired
    private final CreateSpi createSpi;

    public CreateUseCase(CreateSpi createSpi) {
        this.createSpi = createSpi;
    }

    @Override
    public UData create(U u) {
        return this.createSpi.create(u);
    }
}
