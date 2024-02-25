package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.api.UpdateByIdApi;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.UpdateByIdSpi;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.UUID;

/**
 * UpdateByIdUseCase
 */
public class UpdateByIdUseCase implements UpdateByIdApi {

    @Autowired
    private final UpdateByIdSpi updateByIdSpi;

    public UpdateByIdUseCase(UpdateByIdSpi updateByIdSpi) {
        this.updateByIdSpi = updateByIdSpi;
    }

    @Override
    public UData update(UUID id, Map<String, Object> fields) {
        return this.updateByIdSpi.update(id, fields);
    }
}
