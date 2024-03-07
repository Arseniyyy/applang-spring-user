package com.arsenydeveloper.applang.application.data;

import java.time.LocalDate;
import java.util.UUID;

import com.arsenydeveloper.applang.domain.model.enumerable.nativelanguage.NativeLanguageEnum;
import com.arsenydeveloper.applang.domain.model.enumerable.registrationmethod.RegistrationMethodEnum;
import com.arsenydeveloper.applang.domain.model.enumerable.subscriptiontype.SubscriptionTypeEnum;

/**
 * UData
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */

public class UData {

    private UUID id;
    private String email;
    private String nickname;
    private String password;
    private LocalDate dateOfBirth;
    private Integer age;
    private NativeLanguageEnum nativeLanguage;
    private SubscriptionTypeEnum subscription;
    private RegistrationMethodEnum registrationMethod;
    private boolean enabled;
    private String verificationCode;

    public UData() {
    }

    @Override
    public String toString() {
        return email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public NativeLanguageEnum getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(NativeLanguageEnum nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public SubscriptionTypeEnum getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionTypeEnum subscription) {
        this.subscription = subscription;
    }

    public RegistrationMethodEnum getRegistrationMethod() {
        return registrationMethod;
    }

    public void setRegistrationMethod(RegistrationMethodEnum registrationMethod) {
        this.registrationMethod = registrationMethod;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

