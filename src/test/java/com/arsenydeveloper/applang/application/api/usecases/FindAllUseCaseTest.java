package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.application.spi.FindAllSpi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * FindAllUseCaseTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
public class FindAllUseCaseTest {

    @Mock
    private FindAllSpi findAllSpi;

    @Mock
    private List<UData> uDataMocks;

    @InjectMocks
    private FindAllUseCase findAllUseCase;

    @Test
    void findAll_WhenAtLeastOneUExists_DelegatesToSpiAndReturnsUData() {
        // given
        when(findAllSpi.findAll()).thenReturn(uDataMocks);

        // when
        List<UData> actualData = findAllUseCase.findAll();

        // then
        assertNotNull(actualData);
        assertFalse(actualData.isEmpty());
        assertEquals(uDataMocks, actualData);
        verify(findAllSpi).findAll();
    }
}
