package com.arsenydeveloper.applang.application.api.usecases;

import com.arsenydeveloper.applang.application.spi.DeleteByIdSpi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;
import static org.mockito.Mockito.verify;

/**
 * DeleteByIdUseCaseTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
public class DeleteByIdUseCaseTest {

    private final UUID uuid = UUID.randomUUID();

    @Mock
    private DeleteByIdSpi deleteByIdSpi;

    @InjectMocks
    private DeleteByIdUseCase deleteByIdUseCase;

    @Test
    void deletebyId_whenUExists_DelegeatesToSpiAndReturnsNothing() {
        // when
        deleteByIdUseCase.delete(uuid);

        // then
        verify(deleteByIdSpi).delete(uuid);
    }
}
