package com.arsenydeveloper.applang.adapters.spi.jpa;

import com.arsenydeveloper.applang.application.dao.URepository;
import com.arsenydeveloper.applang.application.spi.DeleteByIdSpi;
import com.arsenydeveloper.applang.domain.model.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * JpaClientDeleteById
 */
@Service
public class JpaClientDeleteById implements DeleteByIdSpi {

    @Autowired
    private URepository repository;

    @Override
    public void delete(UUID id) {
        U u = this.repository.findById(id).get();
        this.repository.delete(u);
    }
}
