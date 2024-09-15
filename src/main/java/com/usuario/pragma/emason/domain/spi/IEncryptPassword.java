package com.usuario.pragma.emason.domain.spi;

public interface IEncryptPassword {
    String encryptPassword(String plainPassword);
    boolean verifyPassword(String plainPassword, String hashedPassword);
}
