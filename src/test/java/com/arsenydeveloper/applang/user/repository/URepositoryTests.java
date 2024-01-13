package com.arsenydeveloper.applang.user.repository;

import java.util.Optional;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.arsenydeveloper.applang.user.persistence.U;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class URepositoryTests {

    @Autowired
    private URepository uRepository;

    @Test
    public void findByEmail_WhenEmailExists_ReturnsU() {
    }
}
