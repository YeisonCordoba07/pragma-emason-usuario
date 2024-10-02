package com.usuario.pragma.emason.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

    @Test
    void testConstructorWithAllArgs() {
        // Arrange
        String name = "John";
        String lastName = "Doe";
        Long identityDocument = 12345678L;
        String phone = "555-5555";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        String email = "john.doe@example.com";
        String password = "password123";


        // Act
        UserAccount userAccount = new UserAccount(name, lastName, identityDocument, phone, birthDate, email, password, EnumRole.AUX_BODEGA);

        // Assert
        assertEquals(name, userAccount.getName());
        assertEquals(lastName, userAccount.getLastName());
        assertEquals(identityDocument, userAccount.getIdentityDocument());
        assertEquals(phone, userAccount.getPhone());
        assertEquals(birthDate, userAccount.getBirthDate());
        assertEquals(email, userAccount.getEmail());
        assertEquals(password, userAccount.getPassword());
        assertEquals(EnumRole.AUX_BODEGA, userAccount.getRole());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        // Arrange
        UserAccount userAccount = new UserAccount();
        String name = "Jane";
        String lastName = "Doe";
        Long identityDocument = 87654321L;
        String phone = "555-5556";
        LocalDate birthDate = LocalDate.of(1995, 5, 15);
        String email = "jane.doe@example.com";
        String password = "securePassword";


        // Act
        userAccount.setName(name);
        userAccount.setLastName(lastName);
        userAccount.setIdentityDocument(identityDocument);
        userAccount.setPhone(phone);
        userAccount.setBirthDate(birthDate);
        userAccount.setEmail(email);
        userAccount.setPassword(password);
        userAccount.setRole(EnumRole.AUX_BODEGA);

        // Assert
        assertEquals(name, userAccount.getName());
        assertEquals(lastName, userAccount.getLastName());
        assertEquals(identityDocument, userAccount.getIdentityDocument());
        assertEquals(phone, userAccount.getPhone());
        assertEquals(birthDate, userAccount.getBirthDate());
        assertEquals(email, userAccount.getEmail());
        assertEquals(password, userAccount.getPassword());
        assertEquals(EnumRole.AUX_BODEGA, userAccount.getRole());
    }


    @Test
    void testSetIdAndGetId() {
        // Arrange
        UserAccount userAccount = new UserAccount();
        Long id = 10L;

        // Act
        userAccount.setId(id);

        // Assert
        assertEquals(id, userAccount.getId());
    }


    @Test
    void testNotEquals() {
        // Arrange
        UserAccount userAccount1 = new UserAccount("John", "Doe", 12345678L, "555-5555", LocalDate.of(1990, 1, 1), "john.doe@example.com", "password123", EnumRole.AUX_BODEGA);
        UserAccount userAccount2 = new UserAccount("Jane", "Doe", 87654321L, "555-5556", LocalDate.of(1995, 5, 15), "jane.doe@example.com", "securePassword", EnumRole.AUX_BODEGA);

        // Act & Assert
        assertNotEquals(userAccount1, userAccount2);
    }
}