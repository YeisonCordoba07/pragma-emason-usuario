package com.usuario.pragma.emason.domain.usecase;


import com.usuario.pragma.emason.domain.exception.RoleNotFoundException;
import com.usuario.pragma.emason.domain.model.Role;
import com.usuario.pragma.emason.domain.spi.IRolePersistence;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;
import com.usuario.pragma.emason.domain.util.DomainConstant;
import com.usuario.pragma.emason.domain.exception.UnderAgeException;
import com.usuario.pragma.emason.domain.model.UserAccount;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserAccountUseCaseTest {

    @Mock
    private IUserAccountPersistence iUserAccountPersistence;

    @Mock
    private IRolePersistence iRolePersistence;

    @InjectMocks
    private UserAccountUseCase userAccountUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUserAccount_SuccessfulCreation() {
        // Arrange
        UserAccount userAccount = new UserAccount();
        userAccount.setBirthDate(LocalDate.of(2000, 1, 1));
        userAccount.setRole(1L);
        userAccount.setPassword("password123");

        Role role = new Role();
        role.setId(1L);

        when(iRolePersistence.getRoleById(1L)).thenReturn(role);

        // Act
        userAccountUseCase.createUserAccount(userAccount);

        // Assert
        verify(iUserAccountPersistence).createUserAccount(any(UserAccount.class));

    }


    @Test
    void createUserAccount_ThrowsUnderAgeException() {
        // Arrange
        UserAccount userAccount = new UserAccount();
        userAccount.setBirthDate(LocalDate.now().minusYears(16)); // User is 16 years old
        userAccount.setRole(1L);

        // Act & Assert
        UnderAgeException exception = assertThrows(UnderAgeException.class, () ->
                userAccountUseCase.createUserAccount(userAccount)
        );
        assertEquals(DomainConstant.UNDER_AGE_EXCEPTION, exception.getMessage());
        verify(iUserAccountPersistence, never()).createUserAccount(any(UserAccount.class));

    }


    @Test
    void createUserAccount_ThrowsRoleNotFoundException() {
        // Arrange
        UserAccount userAccount = new UserAccount();
        userAccount.setBirthDate(LocalDate.of(2000, 1, 1));
        userAccount.setRole(1L);
        userAccount.setPassword("password123");

        when(iRolePersistence.getRoleById(1L)).thenReturn(null);

        // Act & Assert
        RoleNotFoundException exception = assertThrows(RoleNotFoundException.class, () ->
                userAccountUseCase.createUserAccount(userAccount)
        );
        assertEquals(DomainConstant.ROLE_NOT_FOUND_EXCEPTION, exception.getMessage());
        verify(iUserAccountPersistence, never()).createUserAccount(any(UserAccount.class));
    }



    @Test
    void isAdult_ReturnsTrue_WhenUserIsAdult() {
        // Arrange
        LocalDate birthDate = LocalDate.now().minusYears(18);

        // Act
        boolean isAdult = userAccountUseCase.isAdult(birthDate);

        // Assert
        assertTrue(isAdult);
    }

    @Test
    void isAdult_ReturnsFalse_WhenUserIsNotAnAdult() {
        // Arrange
        LocalDate birthDate = LocalDate.now().minusYears(17);

        // Act
        boolean isAdult = userAccountUseCase.isAdult(birthDate);

        // Assert
        assertFalse(isAdult);
    }
}