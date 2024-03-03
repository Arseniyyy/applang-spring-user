package com.arsenydeveloper.applang.application.dao;

import com.arsenydeveloper.applang.domain.model.U;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * URepository
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Repository
public interface URepository extends JpaRepository<U, UUID> {
}
