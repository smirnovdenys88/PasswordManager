package com.project.password.manager.secure.jwt;

public class Constants {

    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 24 * 60 * 60;
    public static final String SIGNING_KEY = "D87B6573EA18E86A66188BEF12EA1";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    private Constants() {
    }
}
