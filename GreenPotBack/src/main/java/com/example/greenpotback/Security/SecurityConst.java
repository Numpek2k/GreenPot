package com.example.greenpotback.Security;

public class SecurityConst {
    //multiplication pattern for EXPIR_TIME milliseconds * seconds * minutes * hours * days
    public static final long JWT_ACCESS_EXPIR_TIME = 1000 * 60 * 60; //1 hour
    public static final long JWT_REFRESH_EXPIR_TIME = 1000 * 60 * 60 * 24 * 10; // 10 day
    public static final String JWT_SECRET = "HereIsSomeSuperSecret";
    public static final String JWT_TOKEN_TYPE = "Bearer ";
}
