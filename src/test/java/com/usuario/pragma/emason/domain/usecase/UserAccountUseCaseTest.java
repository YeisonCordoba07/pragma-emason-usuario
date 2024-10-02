package com.usuario.pragma.emason.domain.usecase;



import com.usuario.pragma.emason.domain.exception.AccessDeniedException;
import com.usuario.pragma.emason.domain.spi.IUserAccountPersistence;
import com.usuario.pragma.emason.domain.util.DomainConstant;
import com.usuario.pragma.emason.domain.exception.UnderAgeException;
import com.usuario.pragma.emason.domain.model.UserAccount;


import com.usuario.pragma.emason.domain.model.EnumRole;
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
        userAccount.setId(1L);
        userAccount.setName("John");
        userAccount.setLastName("Doe");
        userAccount.setIdentityDocument(123456789L);
        userAccount.setPhone("555-1234");
        userAccount.setBirthDate(LocalDate.of(1990, 5, 15));
        userAccount.setEmail("john.doe@example.com");
        userAccount.setPassword("password123");
        userAccount.setRole(EnumRole.AUX_BODEGA);


        // Act
        userAccountUseCase.createUserAccount(userAccount);

        // Assert
        verify(iUserAccountPersistence).createUserAccount(any(UserAccount.class));

    }


    @Test
    void createUserAccount_ThrowsUnderAgeException() {
        // Arrange
        UserAccount userAccount = new UserAccount();

        userAccount.setId(1L);
        userAccount.setName("John");
        userAccount.setLastName("Doe");
        userAccount.setIdentityDocument(123456789L);
        userAccount.setPhone("555-1234");
        userAccount.setBirthDate(LocalDate.now().minusYears(16));  // User is 16 years old
        userAccount.setEmail("john.doe@example.com");
        userAccount.setPassword("password123");
        userAccount.setRole(EnumRole.AUX_BODEGA);

        // Act & Assert
        UnderAgeException exception = assertThrows(UnderAgeException.class, () ->
                userAccountUseCase.createUserAccount(userAccount)
        );
        assertEquals(DomainConstant.UNDER_AGE_EXCEPTION, exception.getMessage());
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

    @Test
    void findByEmail_SuccessfulSearch() {
        // Arrange

        UserAccount userAccount = new UserAccount();
        userAccount.setId(1L);
        userAccount.setName("John");
        userAccount.setLastName("Doe");
        userAccount.setIdentityDocument(123456789L);
        userAccount.setPhone("555-1234");
        userAccount.setBirthDate(LocalDate.of(1990, 5, 15));
        userAccount.setEmail("john.doe@example.com");
        userAccount.setPassword("password123");
        userAccount.setRole(EnumRole.AUX_BODEGA);

        when(iUserAccountPersistence.findByEmail(userAccount.getEmail())).thenReturn(userAccount);

        UserAccount result = userAccountUseCase.findByEmail(userAccount.getEmail());
        assertEquals(userAccount, result);
        assertEquals(userAccount.getId(), result.getId());
        assertEquals(userAccount.getName(), result.getName());
        assertEquals(userAccount.getLastName(), result.getLastName());
        assertEquals(userAccount.getIdentityDocument(), result.getIdentityDocument());
        assertEquals(userAccount.getPhone(), result.getPhone());
        assertEquals(userAccount.getBirthDate(), result.getBirthDate());
        assertEquals(userAccount.getEmail(), result.getEmail());
        assertEquals(userAccount.getPassword(), result.getPassword());
        assertEquals(userAccount.getRole(), result.getRole());

        verify(iUserAccountPersistence, times(1)).findByEmail(userAccount.getEmail());
    }


    @Test
    void createUserAccount_ThrowsAccessDeniedException() {
        // Arrange
        UserAccount userAccount = new UserAccount();

        userAccount.setName("John");
        userAccount.setLastName("Doe");
        userAccount.setIdentityDocument(123456789L);
        userAccount.setPhone("555-1234");
        userAccount.setBirthDate(LocalDate.now().minusYears(20));
        userAccount.setEmail("john.doe@example.com");
        userAccount.setPassword("password123");
        userAccount.setRole(EnumRole.ADMIN);

        // Act & Assert
        AccessDeniedException exception = assertThrows(AccessDeniedException.class, () ->
                userAccountUseCase.createUserAccount(userAccount)
        );
        assertEquals(DomainConstant.ACCESS_DENIED_EXCEPTION_MESSAGE, exception.getMessage());
        verify(iUserAccountPersistence, never()).createUserAccount(any(UserAccount.class));

    }
}