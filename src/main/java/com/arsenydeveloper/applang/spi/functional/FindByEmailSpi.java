package com.arsenydeveloper.applang.spi.functional;

import com.arsenydeveloper.applang.persistence.U;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

/**
 * FindByIdApi
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@FunctionalInterface
public interface FindByEmailSpi {

    @Query("SELECT u FROM U u WHERE u.email = ?1")
    Optional<U> findByEmail(String email);
}
