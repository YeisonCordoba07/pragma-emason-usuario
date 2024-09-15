package com.usuario.pragma.emason.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void testRoleConstructorWithParameters() {
        // Arrange & Act
        Role role = new Role("Admin", "Administrator role");

        // Assert
        assertEquals("Admin", role.getName());
        assertEquals("Administrator role", role.getDescription());
    }

    @Test
    void testRoleDefaultConstructor() {
        // Arrange & Act
        Role role = new Role();

        // Assert
        assertNull(role.getId()); // Default value should be null
        assertNull(role.getName());
        assertNull(role.getDescription());
    }

    @Test
    void testSetAndGetId() {
        // Arrange
        Role role = new Role();
        Long expectedId = 1L;

        // Act
        role.setId(expectedId);

        // Assert
        assertEquals(expectedId, role.getId());
    }

    @Test
    void testSetAndGetName() {
        // Arrange
        Role role = new Role();
        String expectedName = "User";

        // Act
        role.setName(expectedName);

        // Assert
        assertEquals(expectedName, role.getName());
    }

    @Test
    void testSetAndGetDescription() {
        // Arrange
        Role role = new Role();
        String expectedDescription = "User role";

        // Act
        role.setDescription(expectedDescription);

        // Assert
        assertEquals(expectedDescription, role.getDescription());
    }
}