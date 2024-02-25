package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.api.FindAllApi;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.FindAllSpi;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * FindAllUseCase
 */
public class FindAllUseCase implements FindAllApi {

    @Autowired
    private final FindAllSpi findAllSpi;

    public FindAllUseCase(FindAllSpi findAllSpi) {
        this.findAllSpi = findAllSpi;
    }

    @Override
    public List<UData> findAll() {
        return this.findAllSpi.findAll();
    }
}
