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
import com.zaxxer.hikari.HikariDataSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * AppConfiguration
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Configuration
@PropertySource("classpath:datasource.properties")
public class AppConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setMaximumPoolSize(Integer.valueOf(env.getProperty("spring.datasource.hikari.maximum-pool-size")));

        return dataSource;
    }

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
