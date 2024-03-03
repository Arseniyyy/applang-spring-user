package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.CreateSpi;
import com.arsenydeveloper.applang.domain.model.U;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * CreateUseCase
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
public class CreateUseCaseTest {

    @Mock
    private CreateSpi createSpi;

    @Mock
    private U uMock;

    @Mock
    private UData uDataMock;

    @InjectMocks
    private CreateUseCase createUseCase;

    @Test
    void create_WhenUDoesNotExist_DelegatesToSpiAndReturnsCreatedU() {
        // given
        when(createSpi.create(uMock)).thenReturn(uDataMock);
        // when
        UData uData = createUseCase.create(uMock);
        // then
        verify(createSpi).create(uMock);
        assertNotNull(uData);
    }
}
