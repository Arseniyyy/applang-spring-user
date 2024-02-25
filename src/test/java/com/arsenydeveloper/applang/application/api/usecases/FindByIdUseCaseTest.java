package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.FindByIdSpi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * FindByIdUseCaseTest
 */
@TestPropertySource(locations = "classpath:application-test.properties")
@ExtendWith(MockitoExtension.class)
public class FindByIdUseCaseTest {

    @Mock
    private FindByIdSpi findByIdSpi;

    @Mock
    private UData uDataMock;

    @InjectMocks
    private FindByIdUseCase findByIdUseCase;

    private UUID id;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById_whenUserExists_returnsUserData() {
        // Given
        Mockito.when(findByIdSpi.findById(id)).thenReturn(uDataMock);

        // When
        UData actualUserData = findByIdUseCase.findById(id);

        // Then
        Mockito.verify(findByIdSpi).findById(id);
        assertEquals(uDataMock, actualUserData);
    }
}
