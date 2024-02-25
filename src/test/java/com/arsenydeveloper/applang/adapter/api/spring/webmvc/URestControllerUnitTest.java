package com.arsenydeveloper.applang.adapter.api.spring.webmvc;

import com.arsenydeveloper.applang.adapters.api.spring.webmvc.URestController;
import com.arsenydeveloper.applang.application.api.CreateApi;
import com.arsenydeveloper.applang.application.api.DeleteByIdApi;
import com.arsenydeveloper.applang.application.api.FindAllApi;
import com.arsenydeveloper.applang.application.api.FindByIdApi;
import com.arsenydeveloper.applang.application.api.UpdateByIdApi;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * URestControllerUnitTest
 */
@ExtendWith(MockitoExtension.class)
public class URestControllerUnitTest {

    @Mock
    FindAllApi findAllApi;

    @Mock
    FindByIdApi findByIdApi;

    @Mock
    CreateApi createApi;

    @Mock
    UpdateByIdApi updateByIdApi;

    @Mock
    DeleteByIdApi deleteByIdApi;

    @Mock
    UUtils utils;

    @InjectMocks
    URestController controller;
}
