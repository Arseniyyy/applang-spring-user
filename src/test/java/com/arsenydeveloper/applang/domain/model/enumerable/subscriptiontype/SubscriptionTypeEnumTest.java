package com.arsenydeveloper.applang.domain.model.enumerable.subscriptiontype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * SubscriptionTypeEnumTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class SubscriptionTypeEnumTest {

    @Test
    void testLength() {
        assertEquals(2, SubscriptionTypeEnum.values().length);
    }

    @Test
    void getCode_ReturnsValidCodeOfEnum() {
        assertEquals("FREE", SubscriptionTypeEnum.FREE.getCode());
        assertEquals("PAID", SubscriptionTypeEnum.PAID.getCode());
    }
}
