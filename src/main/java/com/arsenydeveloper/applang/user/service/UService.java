package com.arsenydeveloper.applang.user.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.arsenydeveloper.applang.user.persistence.U;
import com.arsenydeveloper.applang.user.repository.URepository;

/**
 * Class used to act as a service layer that makes queries
 * to the database via <code>URepository</code> interface.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Service
public class UService {

    private final URepository uRepository;
    private static final String NO_USER_FOUND_ERROR_MESSAGE = "No user found with provided id.";
    private static final String THIS_EMAIL_ALREADY_TAKEN_ERROR_MESSAGE = "This email already taken.";

    @Autowired
    public UService(URepository uRepository) {
        this.uRepository = uRepository;
    }

    /**
     * Fetch all {@code U} instances from the database.
     */
    public List<U> findAll() {
        return uRepository.findAll();
    }

    public U findSpecific(UUID id) {
        Optional<U> u = uRepository.findById(id);

        return u.get();
    }

    /**
     * Fetch a single {@code U} instance by the provided email.
     */
    public Optional<U> findByEmail(String email) {
        return uRepository.findByEmail(email);
    }

    /**
     * Create a {@code U} instance.
     */
    public U create(U u) throws IllegalStateException {
        Optional<U> uOptional = uRepository.findByEmail(u.getEmail());

        if (uOptional.isPresent()) {
            throw new IllegalStateException(THIS_EMAIL_ALREADY_TAKEN_ERROR_MESSAGE);
        }

        return save(u);
    }

    /**
     * Partially update a {@code U} instance.
     */
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

    /**
     * Delete a {@code U} instance.
     */
    public void delete(UUID id) {
        Optional<U> uOptional = uRepository.findById(id);

        if (uOptional.isPresent()) {
            uRepository.deleteById(id);
            return;
        }
        uOptional.get();
    }

    /**
     * Save a {@code U} instance in the database.
     */
    private U save(U u) {
        return uRepository.save(u);
    }
}
