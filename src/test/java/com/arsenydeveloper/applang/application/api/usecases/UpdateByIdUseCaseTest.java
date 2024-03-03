package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.spi.UpdateByIdSpi;
import com.arsenydeveloper.applang.application.data.UData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * UpdateByIdUseCaseTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
public class UpdateByIdUseCaseTest {

    @Mock
    private UpdateByIdSpi updateByIdSpi;

    @InjectMocks
    private UpdateByIdUseCase updateByIdUseCase;

    @Test
    void updateById_whenUExists_DelegatesToSpiAndReturnsUData() {
        // given
        UUID uuid = UUID.randomUUID();
        Map<String, Object> fields = new HashMap<>();
        fields.put("nickname", "nickname-updated");
        UData updatedUData = mock(UData.class);
        when(updateByIdSpi.update(uuid, fields)).thenReturn(updatedUData);

        // when
        UData result = updateByIdUseCase.update(uuid, fields);

        // then
        assertNotNull(result);
        assertEquals(updatedUData, result);
        verify(updateByIdSpi).update(uuid, fields);
    }
}
