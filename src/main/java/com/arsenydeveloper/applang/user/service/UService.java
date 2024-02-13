package com.arsenydeveloper.applang.user.service;

import com.arsenydeveloper.applang.user.persistence.U;
import com.arsenydeveloper.applang.user.repository.URepository;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

/**
 * Class used to act as a service layer that makes queries
 * to the database via <code>URepository</code> interface.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Service
public class UService implements IUService {

    private final URepository uRepository;

    @Autowired
    public UService(URepository uRepository) {
        this.uRepository = uRepository;
    }

    public List<U> findAll() {
        return uRepository.findAll();
    }

    public U findById(UUID id) {
        Optional<U> u = uRepository.findById(id);

        return u.get();
    }

    public Optional<U> findByEmail(String email) {
        return uRepository.findByEmail(email);
    }

    public U create(U u) throws IllegalStateException {
        return save(u);
    }

    public U partialUpdate(UUID id, Map<String, Object> fields) throws IllegalStateException {
        Optional<U> uOptional = uRepository.findById(id);

        if (uOptional.isPresent()) {
            U uExisting = uOptional.get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(U.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, uExisting, value);
            });

            return save(uExisting);
        }

        return uOptional.get();
    }

    public void delete(UUID id) {
        Optional<U> uOptional = uRepository.findById(id);

        if (uOptional.isPresent()) {
            uRepository.deleteById(id);
            return;
        }
        uOptional.get();
    }

    private U save(U u) {
        return uRepository.save(u);
    }
}
