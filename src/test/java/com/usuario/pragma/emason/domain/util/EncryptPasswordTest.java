package com.usuario.pragma.emason.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptPasswordTest {

    @Test
    void testEncryptPassword() {
// Arrange
        String plainPassword = "myPassword123";

        // Act
        String hashedPassword = EncryptPassword.encryptPassword(plainPassword);

        // Assert
        assertNotNull(hashedPassword); // Verify that the hash is not null
        assertNotEquals(plainPassword, hashedPassword); // Verify that the hash is different from the original password
    }

    @Test
    void testVerifyPassword_Matching() {
        // Arrange
        String plainPassword = "myPassword123";
        String hashedPassword = EncryptPassword.encryptPassword(plainPassword);

        // Act
        boolean isMatch = EncryptPassword.verifyPassword(plainPassword, hashedPassword);

        // Assert
        assertTrue(isMatch); // Verify that the passwords match
    }

    @Test
    void testVerifyPassword_NotMatching() {
        // Arrange
        String plainPassword = "myPassword123";
        String wrongPassword = "wrongPassword";
        String hashedPassword = EncryptPassword.encryptPassword(plainPassword);

        // Act
        boolean isMatch = EncryptPassword.verifyPassword(wrongPassword, hashedPassword);

        // Assert
        assertFalse(isMatch); // Verify that the passwords do not match
    }
}