package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.FindByIdSpi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * FindByIdUseCaseTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
public class FindByIdUseCaseTest {

    private final UUID id = UUID.randomUUID();

    @Mock
    private FindByIdSpi findByIdSpi;

    @Mock
    private UData uDataMock;

    @InjectMocks
    private FindByIdUseCase findByIdUseCase;

    @Test
    public void findById_whenUExists_DelegatesToSpiAndReturnsUData() {
        // Given
        when(findByIdSpi.findById(id)).thenReturn(uDataMock);

        // When
        UData actualUData = findByIdUseCase.findById(id);

        // Then
        verify(findByIdSpi).findById(id);
        assertEquals(uDataMock, actualUData);
    }
}
