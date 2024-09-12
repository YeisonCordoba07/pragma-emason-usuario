package com.usuario.pragma.emason.infrastructure.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="user_account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(unique = true, nullable = false, length = 100)
    private Long identityDocument;

    @Column(unique = true, nullable = false, length = 13)
    private String phone;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private RoleEntity roleId;

}
