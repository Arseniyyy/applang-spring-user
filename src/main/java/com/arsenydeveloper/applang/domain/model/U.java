package com.arsenydeveloper.applang.domain.model;

import com.arsenydeveloper.applang.domain.model.enumerable.nativelanguage.NativeLanguageEnum;
import com.arsenydeveloper.applang.domain.model.enumerable.registrationmethod.RegistrationMethodEnum;
import com.arsenydeveloper.applang.domain.model.enumerable.subscriptiontype.SubscriptionTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

/**
 * Entity, representing a user.
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Entity
@Table(name = "u")
public class U {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, updatable = false)
    private UUID id;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Column(name = "nickname", unique = true, length = 255)
    private String nickname;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @Past
    @Column(name = "date_of_birth", updatable = false)
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @Column(name = "native_language")
    private NativeLanguageEnum nativeLanguage;

    @Column(name = "subscription")
    private SubscriptionTypeEnum subscription;

    @Column(name = "registrationMethod")
    private RegistrationMethodEnum registrationMethod;

    @Column(name = "enabled")
    private boolean enabled;

    @NotEmpty
    @Column(name = "verificationCode", length = 6)
    private String verificationCode;

    public U() {
        super();
        this.enabled = false;
    }

    @PrePersist
    private void prePersist() {
        this.enabled = false;
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

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
