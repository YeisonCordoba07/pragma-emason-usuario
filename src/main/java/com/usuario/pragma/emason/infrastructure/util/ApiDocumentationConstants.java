package com.usuario.pragma.emason.infrastructure.util;

public class ApiDocumentationConstants {


    private ApiDocumentationConstants() {
    }



    public static final String STATUS_200 = "200";
    public static final String STATUS_201 = "201";
    public static final String STATUS_400 = "400";
    public static final String STATUS_500 = "500";

    public static final String OPERATION_SUMMARY_CREATE = "Create a new user account";

    public static final String OPERATION_DESCRIPTION_CREATE =
            "This endpoint creates a new user account based on the provided UserAccountRequestDTO. " +
                    "The account information must be valid, and if successfully created, a 201 status code is returned.";
    public static final String RESPONSE_201_DESCRIPTION = "User account created successfully";
    public static final String RESPONSE_400_DESCRIPTION = "Invalid input";
    public static final String RESPONSE_500_DESCRIPTION = "Server error";



    // AUTHENTICATION CONTROLLER

    public static final String LOGIN_SUMMARY = "Login a user";
    public static final String REGISTER_SUMMARY = "Register a user";

    public static final String LOGIN_DESCRIPTION = "Authenticates a user with username and password";
    public static final String REGISTER_DESCRIPTION = "Registers a new user in the system";

    public static final String SUCCESSFULLY_AUTHENTICATED = "Successfully authenticated";
    public static final String SUCCESSFULLY_REGISTERED = "Successfully registered";

    public static final String INVALID_CREDENTIALS = "Invalid credentials";
    public static final String INVALID_INPUT_DATA = "Invalid input data";
    public static final String SERVER_ERROR = "Server error";


    //SECURITY CONFIG
    // Authorities
    public static final String AUTHORITY_ADMIN = "ADMIN";

    // URL paths
    public static final String AUTH_PATH = "/auth/**";
    public static final String USER_PATH = "/user/**";

}
