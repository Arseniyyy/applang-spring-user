package com.arsenydeveloper.applang.adapters.spi.jpa;

import com.arsenydeveloper.applang.application.dao.URepository;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.FindByIdSpi;
import com.arsenydeveloper.applang.domain.model.U;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * JpaClientFindById
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Service
public class JpaClientFindById implements FindByIdSpi {

    @Autowired
    private URepository uRepository;

    @Autowired
    private UUtils utils;

    @Override
    public UData findById(UUID id) {
        U u = this.uRepository.findById(id).get();

        return utils.convertToData(u);
    }
}
