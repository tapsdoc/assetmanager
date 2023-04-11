package com.example.assetmanager.common.constant;

public class SecurityConstant {

    public static final long EXPIRATION_TIME = 432_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String GET_ARRAYS_LLC = "Get Arrays, LLC";
    public static final String GET_ARRAYS_ADMINISTRATION = "Users Management Portal";
    public static final String AUTHORITIES = "Authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to login in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have access to this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    //public static final String[] PUBLIC_URLS = {"/user/login", "/user/register", "/user/resetpassword/**", "/user/image/**"};
    public static final String[] PUBLIC_URLS = { "**"};
}
