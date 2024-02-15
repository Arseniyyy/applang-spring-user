// package com.arsenydeveloper.applang.controller;

// import com.arsenydeveloper.applang.repository.URepository;
// import com.arsenydeveloper.applang.service.UService;
// import com.arsenydeveloper.applang.util.UUtils;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.RequestBuilder;
// import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @WebMvcTest(UController.class)
// @ExtendWith(MockitoExtension.class)
// @TestPropertySource(locations = "classpath:application-test.properties")
// @AutoConfigureMockMvc
// class UControllerTest {
//     @Autowired MockMvc mockMvc;
//     @Autowired ObjectMapper objectMapper;
//     @MockBean URepository uRepository;
//     @MockBean UUtils uUtils;

//     @MockBean UService uService;
//     @InjectMocks UController uController;
//     @Value("${info.api.u-url}") private String endpoint;

//     @AfterEach
//     void cleanUpDatabase() {
//         uRepository.deleteAll();
//     }

//     @Test
//     void contextLoads() {
//     }

//     @Test
//     void getAllU_ReturnsValidResponseEntity() throws Exception {
//         // given
//         RequestBuilder requestBuilder = get(endpoint).with(httpBasic("user1", "password1"));

//         // when
//         this.mockMvc.perform(requestBuilder)
//             // then
//             .andExpectAll(
//                 status().isOk(),
//                 content().contentType(MediaType.APPLICATION_JSON)
//             );
//     }

//      @Test
//      void getSpecificU_shouldReturnOk() throws Exception {
//          UUID id = UUID.randomUUID();
//          String endpoint = String.format("%s/%s", this.endpoint, id);
//          System.out.println(endpoint);
//          U mockEntity = new U();
//          UDTO uDTO = new UDTO();

//          mockEntity.setId(id);
//          uDTO.setId(id);

//          when(uService.findById(id)).thenReturn(mockEntity);
//          when(uUtils.convertToDTO(mockEntity)).thenReturn(uDTO);

//          mockMvc.perform(get(endpoint)
//              .contentType(MediaType.APPLICATION_JSON))
//              .andExpect(status().isOk())
//              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//              .andExpect(jsonPath("$").isMap());
//      }

//      void createU_shouldReturnCreated() throws Exception {}
// }
