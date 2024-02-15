package com.arsenydeveloper.applang.api;

import com.arsenydeveloper.applang.persistence.U;
import com.arsenydeveloper.applang.spi.functional.FindByEmailSpi;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URepository extends JpaRepository<U, UUID>, FindByEmailSpi {
}
