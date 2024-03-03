package com.arsenydeveloper.applang.domain.model.enumerable.nativelanguage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * NativeLanguageEnumTest
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
public class NativeLanguageEnumTest {

    @Test
    void testLength() {
        assertEquals(2, NativeLanguageEnum.values().length);
    }

    @Test
    void getCode_ReturnsValidCodeOfEnum() {
        assertEquals("ENGLISH", NativeLanguageEnum.ENGLISH.getCode());
        assertEquals("RUSSIAN", NativeLanguageEnum.RUSSIAN.getCode());
    }
}
