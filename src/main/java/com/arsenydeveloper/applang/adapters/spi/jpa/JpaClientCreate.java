package com.arsenydeveloper.applang.adapters.spi.jpa;

import com.arsenydeveloper.applang.application.dao.URepository;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.CreateSpi;
import com.arsenydeveloper.applang.domain.model.U;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * JpaClientCreate
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Service
public class JpaClientCreate implements CreateSpi {

    @Autowired
    private URepository repository;

    @Autowired
    private UUtils utils;

    @Override
    public UData create(U u) {
        U savedInstance = this.repository.save(u);

        return utils.convertToData(savedInstance);
    }
}
