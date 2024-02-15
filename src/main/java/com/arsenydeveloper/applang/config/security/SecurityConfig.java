package com.arsenydeveloper.applang.config.security;

import com.arsenydeveloper.applang.config.security.handler.CustomAccessDeniedHandler;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig {

    @Value("${okta.oauth2.issuer}")
    private String issuer;

    @Value("${okta.oauth2.audience}")
    private String audience;

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, @Value("${info.resource-server.cors.allowed-origins}") List<String> allowedOrigins)
        throws Exception {
        http
            // .cors(corsCustomizer -> {
            //     if (allowedOrigins.isEmpty()) {
            //         corsCustomizer.disable();
            //     } else {
            //         corsCustomizer.configurationSource(corsConfig(allowedOrigins));
            //     }
            // })
            .cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagementCustomizer -> sessionManagementCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.POST, "/api/v1/u").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/v1/u").authenticated()
                    .requestMatchers(HttpMethod.PATCH, "/api/v1/u/**").authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/api/v1/u/**").authenticated()
                    .requestMatchers("/api/v1/scope").hasAuthority("SCOPE_read:users")
            )
            .oauth2ResourceServer(oauth2ResourceServerCustomizer -> oauth2ResourceServerCustomizer
                    .jwt(Customizer.withDefaults())
            )
            .exceptionHandling(exceptionHandlingCustomizer -> exceptionHandlingCustomizer
                .accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
            );

        return http.build();
    }

    CorsConfigurationSource corsConfig(List<String> allowedOrigins) {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(allowedOrigins);
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("*"));

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
