package com.arsenydeveloper.applang.config;

import org.springframework.context.annotation.Configuration;

import com.arsenydeveloper.applang.user.controller.UUtils;
import com.arsenydeveloper.applang.user.repository.URepository;
import com.arsenydeveloper.applang.user.service.UService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

// @Configuration
// public class AppConfig {

//     @Bean
//     public ModelMapper modelMapper() {
//         return new ModelMapper();
//     }

//     @Bean
//     public UUtils uUtils(ModelMapper modelMapper) {
//         return new UUtils(modelMapper);
//     }
// }
