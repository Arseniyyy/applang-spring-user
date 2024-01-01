package com.arsenydeveloper.applang.user.model;

import java.util.Set;
import java.util.UUID;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Entity, representing <code>U</code> (user).
 * @author Arseniy Koshelnik
 * @since 0.0.1
 */
@Entity
@Table(name = "u")
public class U {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "nickname", unique = true, nullable = false, length = 255)
    private String nickname;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;

    @Column(name = "native_language", nullable = false)
    private String nativeLanguage;

    @Column(name = "subscription", nullable = false)
    private String subscription;

    @Column(name = "registrationMethod", nullable = false)
    private String registrationMethod;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "verificationCode", length = 6, nullable = false)
    private String verificationCode;

    private Set<UUID> words;

    public U() {
    }

    public U(String email, String nickname, LocalDate dateOfBirth, String nativeLanguage, String subscription,
            String registrationMethod, boolean isActive, String verificationCode, Set<UUID> words) {
        this.email = email;
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
        this.nativeLanguage = nativeLanguage;
        this.subscription = subscription;
        this.registrationMethod = registrationMethod;
        this.isActive = isActive;
        this.verificationCode = verificationCode;
        this.words = words;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Count the <code>age</code> property of a <code>U</code> instance.
     */
    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getRegistrationMethod() {
        return registrationMethod;
    }

    public void setRegistrationMethod(String registrationMethod) {
        this.registrationMethod = registrationMethod;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Set<UUID> getWords() {
        return words;
    }

    public void setWords(Set<UUID> words) {
        this.words = words;
    }
}
