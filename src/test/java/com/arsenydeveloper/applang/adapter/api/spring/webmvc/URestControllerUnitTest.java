package com.arsenydeveloper.applang.adapter.api.spring.webmvc;

import com.arsenydeveloper.applang.adapters.api.spring.webmvc.URestController;
import com.arsenydeveloper.applang.adapters.api.spring.webmvc.presentation.UPresentationV1;
import com.arsenydeveloper.applang.application.api.CreateApi;
import com.arsenydeveloper.applang.application.api.DeleteByIdApi;
import com.arsenydeveloper.applang.application.api.FindAllApi;
import com.arsenydeveloper.applang.application.api.FindByIdApi;
import com.arsenydeveloper.applang.application.api.UpdateByIdApi;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.domain.model.U;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * URestControllerUnitTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@ExtendWith(MockitoExtension.class)
class URestControllerUnitTest {

    private final UUID uuid = UUID.randomUUID();
    private final Map<String, Object> fields = new HashMap<>();

    @Mock
    private FindAllApi findAllApi;

    @Mock
    private FindByIdApi findByIdApi;

    @Mock
    private CreateApi createApi;

    @Mock
    private UpdateByIdApi updateByIdApi;

    @Mock
    private DeleteByIdApi deleteByIdApi;

    @Mock
    private UUtils utils;

    @InjectMocks
    URestController controller;

    @Test
    void getAllU_ReturnsValidResponseEntity() {
        // given
        List<UData> uDatas = Collections.singletonList(mock(UData.class));
        List<UPresentationV1> uPresentationV1s = Collections.singletonList(mock(UPresentationV1.class));
        when(findAllApi.findAll()).thenReturn(uDatas);
        when(uPresentationV1s.get(0).getId()).thenReturn(uuid);
        when(utils.convertToListUPresentationV1FromUDataList(uDatas)).thenReturn(uPresentationV1s);

        // when
        ResponseEntity<List<UPresentationV1>> responseEntity = controller.getAllU();

        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(uPresentationV1s, responseEntity.getBody());
        assertEquals(uuid, responseEntity.getBody().get(0).getId());
        verify(findAllApi).findAll();
        verify(utils).convertToListUPresentationV1FromUDataList(uDatas);
    }

    @Test
    void getDetailedU_ReturnsValidResponseEntity() {
        // given
        UData uDataMock = mock(UData.class);
        UPresentationV1 uPresentationV1Mock = mock(UPresentationV1.class);
        when(uDataMock.getId()).thenReturn(uuid);
        when(uPresentationV1Mock.getId()).thenReturn(uuid);
        when(findByIdApi.findById(uDataMock.getId())).thenReturn(uDataMock);
        when(utils.convertToUPresentationV1FromUData(uDataMock)).thenReturn(uPresentationV1Mock);

        // when
        ResponseEntity<UPresentationV1> responseEntity = controller.getDetailedU(uuid);

        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(uPresentationV1Mock, responseEntity.getBody());
        assertEquals(uuid, responseEntity.getBody().getId());
        verify(findByIdApi).findById(uuid);
        verify(utils).convertToUPresentationV1FromUData(uDataMock);
    }

    @Test
    void createU_ReturnsValidResponseEntity() {
        // given
        U uMock = mock(U.class);
        UData uDataMock = mock(UData.class);
        UPresentationV1 uPresentationV1Mock = mock(UPresentationV1.class);
        when(createApi.create(uMock)).thenReturn(uDataMock);
        when(utils.convertToUPresentationV1FromUData(uDataMock)).thenReturn(uPresentationV1Mock);

        // when
        ResponseEntity<UPresentationV1> responseEntity = controller.createU(uMock);

        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(uPresentationV1Mock, responseEntity.getBody());
    }

    @Test
    void updateU_ReturnsValidResponseEntity() {
        // given
        String updatedNickname = "updated_nick";
        fields.put("nickname", updatedNickname);
        UData updatedUDataMock = mock(UData.class);
        UPresentationV1 updatedUPresentationV1Mock = mock(UPresentationV1.class);
        when(updateByIdApi.update(uuid, fields)).thenReturn(updatedUDataMock);
        when(updatedUPresentationV1Mock.getNickname()).thenReturn(updatedNickname);
        when(utils.convertToUPresentationV1FromUData(updatedUDataMock)).thenReturn(updatedUPresentationV1Mock);

        // when
        ResponseEntity<UPresentationV1> responseEntity = controller.partialUpdateU(uuid, fields);

        // then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedUPresentationV1Mock, responseEntity.getBody());
        assertEquals(updatedNickname, responseEntity.getBody().getNickname());
        verify(updateByIdApi).update(uuid, fields);
        verify(utils).convertToUPresentationV1FromUData(updatedUDataMock);
    }

    @Test
    void deleteDetailedU_ReturnsValidResponseEntity() {
        // given
        U uMock = mock(U.class);
        UData uDataMock = mock(UData.class);
        UPresentationV1 uPresentationV1Mock = mock(UPresentationV1.class);
        when(createApi.create(uMock)).thenReturn(uDataMock);
        when(uPresentationV1Mock.getId()).thenReturn(uuid);
        when(utils.convertToUPresentationV1FromUData(uDataMock)).thenReturn(uPresentationV1Mock);

        // when
        ResponseEntity<UPresentationV1> responseEntityCreated = controller.createU(uMock);
        if (responseEntityCreated.getBody().getId() != null) {
            ResponseEntity<Void> responseEntity = controller.deleteDetailedU(uuid);

            // then
            assertNull(responseEntity.getBody());
            assertNotNull(responseEntity);
            assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        }
        else {
            throw new IllegalStateException("Fuck!!!");
        }
    }
}
