package com.arsenydeveloper.applang.domain.model.enumerable.registrationmethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * RegistrationMethodEnumTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class RegistrationMethodEnumTest {

    @Test
    void testLength() {
        assertEquals(3, RegistrationMethodEnum.values().length);
    }

    @Test
    void getCode_ReturnsValidCodeOfEnum() {
        assertEquals("EMAIL", RegistrationMethodEnum.EMAIL.getCode());
        assertEquals("GOOGLE", RegistrationMethodEnum.GOOGLE.getCode());
        assertEquals("VK", RegistrationMethodEnum.VK.getCode());
    }
}
