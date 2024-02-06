// package com.arsenydeveloper.applang.user.persistence.token;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;

// import java.time.LocalDateTime;
// import java.util.UUID;

// @Entity
// @Table(name = "u_deactivated_token")
// public class UDeactivatedToken {

//     @Id
//     @GeneratedValue(strategy = GenerationType.UUID)
//     @Column(name = "id", unique = true)
//     private UUID id;

//     @Column(name = "keep_until", nullable = false)
//     private LocalDateTime keepUntil;

//     public UDeactivatedToken() {
//     }

//     public UDeactivatedToken(UUID id, LocalDateTime keepUntil) {
//         this.id = id;
//         this.keepUntil = keepUntil;
//     }

//     public UUID getId() {
//         return id;
//     }

//     public LocalDateTime getKeepUntil() {
//         return keepUntil;
//     }
// }
