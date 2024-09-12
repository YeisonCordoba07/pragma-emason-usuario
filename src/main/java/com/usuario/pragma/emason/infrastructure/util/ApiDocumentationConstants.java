package com.usuario.pragma.emason.infrastructure.util;

public class ApiDocumentationConstants {
    public static class UserAccount {
        public static final String OPERATION_SUMMARY_CREATE = "Create a new user account";
        public static final String OPERATION_DESCRIPTION_CREATE =
                "This endpoint creates a new user account based on the provided UserAccountRequestDTO. " +
                        "The account information must be valid, and if successfully created, a 201 status code is returned.";
        public static final String RESPONSE_201_DESCRIPTION = "User account created successfully";
        public static final String RESPONSE_400_DESCRIPTION = "Invalid input";
        public static final String RESPONSE_500_DESCRIPTION = "Server error";
        public static final String REQUEST_BODY_DESCRIPTION = "Details of the user account to be created";
    }

    public static class Role {
        public static final String OPERATION_SUMMARY_GET_BY_ID = "Get role by ID";
        public static final String OPERATION_DESCRIPTION_GET_BY_ID =
                "This endpoint retrieves a role based on its ID. If the role is found, it returns the role details.";
        public static final String RESPONSE_200_DESCRIPTION = "Role found successfully";
        public static final String RESPONSE_404_DESCRIPTION = "Role not found";
        public static final String PATH_PARAM_DESCRIPTION = "ID of the role to be retrieved";
    }
}
