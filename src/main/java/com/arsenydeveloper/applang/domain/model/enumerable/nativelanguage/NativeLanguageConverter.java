package com.arsenydeveloper.applang.domain.model.enumerable.nativelanguage;

import org.springframework.lang.NonNull;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

/**
 * NativeLanguageConverter
 */
@Converter(autoApply = true)
public class NativeLanguageConverter implements AttributeConverter<NativeLanguageEnum, String> {

    @Override
    public String convertToDatabaseColumn(@NonNull NativeLanguageEnum nativeLanguageEnum) {
        return nativeLanguageEnum.getCode();
    }

    @Override
    public NativeLanguageEnum convertToEntityAttribute(@NonNull String code) {
        return Stream.of(NativeLanguageEnum.values())
            .filter(v -> v.getCode().equals(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
