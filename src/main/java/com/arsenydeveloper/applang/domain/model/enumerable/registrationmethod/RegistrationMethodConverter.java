package com.arsenydeveloper.applang.domain.model.enumerable.registrationmethod;

import org.springframework.lang.NonNull;
import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;

/**
 * RegistrationMethodConverter
 */
public class RegistrationMethodConverter implements AttributeConverter<RegistrationMethodEnum, String> {

    @Override
    public String convertToDatabaseColumn(@NonNull RegistrationMethodEnum registrationMethodEnum) {
        return registrationMethodEnum.getCode();
    }

    @Override
    public RegistrationMethodEnum convertToEntityAttribute(@NonNull String code) {
        return Stream.of(RegistrationMethodEnum.values())
            .filter(v -> v.getCode().equals(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
