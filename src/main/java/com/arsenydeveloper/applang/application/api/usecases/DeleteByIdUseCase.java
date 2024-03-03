package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.api.DeleteByIdApi;
import com.arsenydeveloper.applang.application.spi.DeleteByIdSpi;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

/**
 * DeleteByIdUseCase
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class DeleteByIdUseCase implements DeleteByIdApi {

    @Autowired
    private final DeleteByIdSpi deleteByIdSpi;

    public DeleteByIdUseCase(DeleteByIdSpi deleteByIdSpi) {
        this.deleteByIdSpi = deleteByIdSpi;
    }

    @Override
    public void delete(UUID id) {
        this.deleteByIdSpi.delete(id);
    }
}
