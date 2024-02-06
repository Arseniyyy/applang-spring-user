package com.arsenydeveloper.applang.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.arsenydeveloper.applang.user.util.UUtils;

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
