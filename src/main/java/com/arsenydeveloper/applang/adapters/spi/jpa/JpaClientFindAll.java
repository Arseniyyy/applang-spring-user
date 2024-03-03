package com.arsenydeveloper.applang.adapters.spi.jpa;

import com.arsenydeveloper.applang.application.dao.URepository;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.FindAllSpi;
import com.arsenydeveloper.applang.domain.model.U;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * JpaClientFindAll
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Service
public class JpaClientFindAll implements FindAllSpi {

    @Autowired
    private URepository repository;

    @Autowired
    private UUtils utils;

    @Override
    public List<UData> findAll() {
        List<U> us = this.repository.findAll();

        return this.utils.convertToDataMultiple(us);
    }
}
