package com.arsenydeveloper.applang.domain.model.enumerable.subscriptiontype;

import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;

/**
 * SubscriptionTypeConverter
 */
public class SubscriptionTypeConverter implements AttributeConverter<SubscriptionTypeEnum, String> {

    @Override
    public String convertToDatabaseColumn(SubscriptionTypeEnum subscriptionTypeEnum) {
        return subscriptionTypeEnum.getCode();
    }

    @Override
    public SubscriptionTypeEnum convertToEntityAttribute(String code) {
        return Stream.of(SubscriptionTypeEnum.values())
            .filter(v -> v.getCode().equals(code))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
