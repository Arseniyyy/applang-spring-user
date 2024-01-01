package com.arsenydeveloper.applang;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;

import com.arsenydeveloper.applang.user.controller.UController;
import com.arsenydeveloper.applang.user.model.dto.UDTO;
import com.arsenydeveloper.applang.user.service.UService;
import com.arsenydeveloper.applang.user.controller.UUtils;

@SpringBootTest
@AutoConfigureMockMvc
class ApplangApplicationTests {

    @Autowired
	private MockMvc mockMvc;

    @MockBean
    private UController uController;

    @MockBean
    private UService uService;

    @MockBean
    private UUtils uUtils;

    @Value("${info.api.u-url}")
    private String uUrl;

    @Test
    void contextLoads() {}

    @Test
    void getAllU_shouldReturnListOfUDTOs() throws Exception {
        List<UDTO> uDTOS = Arrays.asList(new UDTO(), new UDTO());

        // when(uService.findAll()).thenReturn(Collections.emptyList());
        // when(uUtils.convertToDTOMultiple(anyList())).thenReturn(uDTOS);

        mockMvc.perform(get(uUrl))
            .andExpect(status().isOk());
    }
}
