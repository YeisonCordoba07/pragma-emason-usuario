package com.usuario.pragma.emason.infrastructure.util;

import com.usuario.pragma.emason.domain.spi.IEncryptPassword;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EncryptPassword implements IEncryptPassword {



    // Encrypt a password using bcrypt
    @Override
    public  String encryptPassword(String plainPassword) {
        // Generate a random salt
        String salt = BCrypt.gensalt();

        // Encrypt the password using the salt
        return BCrypt.hashpw(plainPassword, salt);
    }



    // Verify if the plain password matches the hashed password
    @Override
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
