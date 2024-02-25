package com.arsenydeveloper.applang.config;

import com.arsenydeveloper.applang.adapters.spi.jpa.JpaClientFindAll;
import com.arsenydeveloper.applang.adapters.spi.jpa.JpaClientFindById;
import com.arsenydeveloper.applang.adapters.spi.jpa.JpaClientCreate;
import com.arsenydeveloper.applang.adapters.spi.jpa.JpaClientDeleteById;
import com.arsenydeveloper.applang.adapters.spi.jpa.JpaClientUpdateById;
import com.arsenydeveloper.applang.application.api.usecases.CreateUseCase;
import com.arsenydeveloper.applang.application.api.usecases.DeleteByIdUseCase;
import com.arsenydeveloper.applang.application.api.usecases.FindAllUseCase;
import com.arsenydeveloper.applang.application.api.usecases.FindByIdUseCase;
import com.arsenydeveloper.applang.application.api.usecases.UpdateByIdUseCase;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
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
        return new UUtils();
    }

    @Bean
    public FindAllUseCase findAllUseCase() {
        return new FindAllUseCase(new JpaClientFindAll());
    }

    @Bean
    public FindByIdUseCase findByIdUseCase() {
        return new FindByIdUseCase(new JpaClientFindById());
    }

    @Bean
    public CreateUseCase createUseCase() {
        return new CreateUseCase(new JpaClientCreate());
    }

    @Bean
    public UpdateByIdUseCase updateByIdUseCase() {
        return new UpdateByIdUseCase(new JpaClientUpdateById());
    }

    @Bean
    public DeleteByIdUseCase deleteByIdUseCase() {
        return new DeleteByIdUseCase(new JpaClientDeleteById());
    }
}
