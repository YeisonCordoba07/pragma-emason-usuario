package com.usuario.pragma.emason.domain.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptPassword {

    // Encrypt a password using bcrypt
    public static String encryptPassword(String plainPassword) {
        // Generate a random salt
        String salt = BCrypt.gensalt();

        // Encrypt the password using the salt
        return BCrypt.hashpw(plainPassword, salt);
    }

    // Verify if the plain password matches the hashed password
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
