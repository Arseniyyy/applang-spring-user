package com.arsenydeveloper.applang.config;

import com.arsenydeveloper.applang.util.UUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UUtils uUtils(ModelMapper modelMapper) {
        return new UUtils(modelMapper);
    }
}
