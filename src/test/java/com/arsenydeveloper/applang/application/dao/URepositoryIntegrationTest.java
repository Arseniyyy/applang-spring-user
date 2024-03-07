package com.arsenydeveloper.applang.application.dao;

import com.arsenydeveloper.applang.domain.model.U;
import com.arsenydeveloper.applang.domain.model.enumerable.nativelanguage.NativeLanguageEnum;
import com.arsenydeveloper.applang.domain.model.enumerable.registrationmethod.RegistrationMethodEnum;
import com.arsenydeveloper.applang.domain.model.enumerable.subscriptiontype.SubscriptionTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * URepositoryTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Testcontainers
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class URepositoryIntegrationTest {

    @Autowired
    URepository repository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgresSqlContainer = new PostgreSQLContainer<>("postgres:alpine");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresSqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresSqlContainer::getUsername);
        registry.add("spring.datasource.password", postgresSqlContainer::getPassword);
    }

    @Test
    void connectionEstablished() {
        assertTrue(postgresSqlContainer.isCreated());
        assertTrue(postgresSqlContainer.isRunning());
    }

    @Test
    void injectedBeansAreNotNull() {
        assertNotNull(postgresSqlContainer);
        assertNotNull(repository);
    }

    @Test
    void findAll_WhenAtLeastOneUExists_ReturnsValidListOfU() {
        createU();
        List<U> us = repository.findAll();

        assertNotNull(us);
        assertNotNull(us.get(0));
        assertNotNull(us.get(0).getId());
    }

    @Test
    void findById_WhenUExists_ReturnsValidU() {
        U u = createU();
        Optional<U> uOptional = repository.findById(u.getId());
        assertNotNull(uOptional.get());
    }

    @Test
    void save_WhenUDoesNotExist_ReturnsValidU() {
        U u = createU();
        assertNotNull(u);
        assertNotNull(u.getId());
    }

    @Test
    void update_WhenUExists_ReturnsValidUpdatedU() {
        String newNickname = "New one";
        U u = createU();

        u.setNickname(newNickname);

        save(u);

        assertEquals(newNickname, repository.findById(u.getId()).get().getNickname());
    }

    @Test
    void delete_WhenUExists_ReturnsNull() {
        U u = createU();
        UUID uuid = u.getId();

        repository.delete(u);
        assertFalse(repository.findById(uuid).isPresent());
    }

    U createU() {
        U u = new U();
        u.setEmail("test@example.com");
        u.setNickname("test_user");
        u.setPassword("password123");
        u.setDateOfBirth(LocalDate.of(1990, 01, 01));
        u.setNativeLanguage(NativeLanguageEnum.ENGLISH);
        u.setSubscription(SubscriptionTypeEnum.FREE);
        u.setRegistrationMethod(RegistrationMethodEnum.EMAIL);
        u.setVerificationCode("123456");
        save(u);

        return u;
    }

    U save(U u) {
        return repository.save(u);
    }
}
