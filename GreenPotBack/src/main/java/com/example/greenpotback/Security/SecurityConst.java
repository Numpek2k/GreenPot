package com.example.greenpotback.Security;

public class SecurityConst {

    //multiplication pattern for EXPIR_TIME milliseconds * seconds * minutes * hours * days
    public static final long JWT_ACCESS_EXPIR_TIME = 1000 * 60 * 60;
    public static final long JWT_REFRESH_EXPIR_TIME = 1000 * 60 * 60 * 24 * 1;
    public static final String JWT_SECRET = "HereIsSomeSuperSecret";
    public static final String JWT_TOKEN_TYPE = "Bearer ";
}
