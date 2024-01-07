package com.arsenydeveloper.applang.config;

import org.springframework.context.annotation.Configuration;

import com.arsenydeveloper.applang.user.controller.UUtils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UUtils uUtils(ModelMapper modelMapper) {
        return new UUtils(modelMapper);
    }
}
