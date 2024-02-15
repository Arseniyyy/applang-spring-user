package com.arsenydeveloper.applang.api.functional;

import com.arsenydeveloper.applang.persistence.U;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

/**
 * FindByEmail
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface FindByEmailApi {

    @Query("SELECT u FROM U u WHERE u.email = ?1")
    Optional<U> findByEmail(String email);
}
