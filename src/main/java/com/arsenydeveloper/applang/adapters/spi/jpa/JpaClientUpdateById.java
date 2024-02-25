package com.arsenydeveloper.applang.adapters.spi.jpa;

import com.arsenydeveloper.applang.application.dao.URepository;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.UpdateByIdSpi;
import com.arsenydeveloper.applang.domain.model.U;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;

/**
 * JpaClientUpdateById
 */
@Service
public class JpaClientUpdateById implements UpdateByIdSpi {

    @Autowired
    private URepository repository;

    @Autowired
    private UUtils utils;

    @Override
    public UData update(UUID id, Map<String, Object> fields) {
        U u = this.repository.findById(id).get();

        fields.forEach((String key, Object value) -> {
            Field field = ReflectionUtils.findField(U.class, key);

            field.setAccessible(true);
            ReflectionUtils.setField(field, u, value);
        });

        this.repository.save(u);

        return this.utils.convertToData(u);
    }
}
