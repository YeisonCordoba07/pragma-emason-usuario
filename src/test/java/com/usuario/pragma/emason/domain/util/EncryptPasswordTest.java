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
        assertNotNull(hashedPassword); // Verifica que el hash no sea nulo
        assertNotEquals(plainPassword, hashedPassword); // Verifica que el hash es diferente a la contraseña original
    }

    @Test
    void testVerifyPassword_Matching() {
        // Arrange
        String plainPassword = "myPassword123";
        String hashedPassword = EncryptPassword.encryptPassword(plainPassword);

        // Act
        boolean isMatch = EncryptPassword.verifyPassword(plainPassword, hashedPassword);

        // Assert
        assertTrue(isMatch); // Verifica que las contraseñas coinciden
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
        assertFalse(isMatch); // Verifica que las contraseñas no coinciden
    }
}