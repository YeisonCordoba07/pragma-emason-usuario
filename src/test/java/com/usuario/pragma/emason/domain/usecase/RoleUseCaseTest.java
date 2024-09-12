package com.usuario.pragma.emason.domain.usecase;

import com.usuario.pragma.emason.domain.model.Role;
import com.usuario.pragma.emason.domain.spi.IRolePersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleUseCaseTest {

    @Mock
    private IRolePersistence iRolePersistence;

    @InjectMocks
    private RoleUseCase roleUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRoleById_Success() {
        // Arrange
        Long roleId = 1L;
        Role expectedRole = new Role("Admin", "Administrator role");
        expectedRole.setId(roleId);


        when(iRolePersistence.getRoleById(roleId)).thenReturn(expectedRole);

        // Act
        Role actualRole = roleUseCase.getRoleById(roleId);

        // Assert
        assertNotNull(actualRole); // Verifica que el rol retornado no sea nulo
        assertEquals(expectedRole.getId(), actualRole.getId()); // Verifica que el ID es correcto
        assertEquals(expectedRole.getName(), actualRole.getName()); // Verifica que el nombre es correcto
        assertEquals(expectedRole.getDescription(), actualRole.getDescription()); // Verifica que la descripción es correcta

        // Verifica que el método de la capa de persistencia fue llamado una vez
        verify(iRolePersistence, times(1)).getRoleById(roleId);
    }

    @Test
    void testGetRoleById_NotFound() {
        // Arrange
        Long roleId = 1L;

        // Simular el comportamiento de la capa de persistencia para devolver `null` cuando no encuentra el rol
        when(iRolePersistence.getRoleById(roleId)).thenReturn(null);

        // Act
        Role actualRole = roleUseCase.getRoleById(roleId);

        // Assert
        assertNull(actualRole); // Verifica que no se encontró el rol

        // Verifica que el método de la capa de persistencia fue llamado una vez
        verify(iRolePersistence, times(1)).getRoleById(roleId);
    }
}