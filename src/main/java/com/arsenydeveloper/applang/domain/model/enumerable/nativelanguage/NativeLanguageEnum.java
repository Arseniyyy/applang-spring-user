package com.arsenydeveloper.applang.domain.model.enumerable.nativelanguage;

/**
 * NativeLanguageEnum
 */
public enum NativeLanguageEnum {

    ENGLISH("ENGLISH"),
    RUSSIAN("RUSSIAN");

    private String code;

    private NativeLanguageEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
