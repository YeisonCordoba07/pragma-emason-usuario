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
        assertNotNull(actualRole); // Verify that the returned role is not null
        assertEquals(expectedRole.getId(), actualRole.getId()); // Verify that the ID is correct
        assertEquals(expectedRole.getName(), actualRole.getName()); // Verify that the name is correct
        assertEquals(expectedRole.getDescription(), actualRole.getDescription()); // Verify that the description is correct

        // Verify that the persistence layer method was called once
        verify(iRolePersistence, times(1)).getRoleById(roleId);
    }

    @Test
    void testGetRoleById_NotFound() {
        // Arrange
        Long roleId = 1L;

        // Simulate the behavior of the persistence layer to return `null` when the role is not found
        when(iRolePersistence.getRoleById(roleId)).thenReturn(null);

        // Act
        Role actualRole = roleUseCase.getRoleById(roleId);

        // Assert
        assertNull(actualRole); // Verify that the role was not found

        // Verify that the persistence layer method was called once
        verify(iRolePersistence, times(1)).getRoleById(roleId);
    }
}