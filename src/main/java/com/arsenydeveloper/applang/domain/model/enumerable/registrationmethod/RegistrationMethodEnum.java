package com.arsenydeveloper.applang.domain.model.enumerable.registrationmethod;

/**
 * RegistrationMethodEnum
 */
public enum RegistrationMethodEnum {

    EMAIL("EMAIL"),
    GOOGLE("GOOGLE"),
    VK("VK");

    private String code;

    private RegistrationMethodEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
