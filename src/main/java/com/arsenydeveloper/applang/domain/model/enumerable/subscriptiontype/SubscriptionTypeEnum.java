package com.arsenydeveloper.applang.domain.model.enumerable.subscriptiontype;

/**
 * SubscriptionTypeEnum
 */
public enum SubscriptionTypeEnum {

    FREE("FREE"),
    PAID("PAID");

    private String code;

    private SubscriptionTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
