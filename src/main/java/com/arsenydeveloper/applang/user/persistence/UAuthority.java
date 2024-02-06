// package com.arsenydeveloper.applang.user.persistence;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;

// import java.util.UUID;

// import jakarta.persistence.Column;

// /**
//  * UAuthority
//  */
// @Entity
// @Table(name = "u_authority")
// public class UAuthority {

//     @Id
//     @GeneratedValue(strategy = GenerationType.UUID)
//     @Column(name = "id", unique = true)
//     private UUID id;

//     @ManyToOne
//     @JoinColumn(nullable = false)
//     private U u;

//     @Column(name = "authority", nullable = false)
//     private String authority;

//     public UAuthority() {
//     }

//     public UAuthority(U u, String authority) {
//         this.u = u;
//         this.authority = authority;
//     }

//     public UUID getId() {
//         return id;
//     }

//     public U getU() {
//         return u;
//     }

//     public String getAuthority() {
//         return authority;
//     }
// }

