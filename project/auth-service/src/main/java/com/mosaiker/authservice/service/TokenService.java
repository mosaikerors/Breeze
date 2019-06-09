package com.mosaiker.authservice.service;

public interface TokenService {

    String createToken(String username, String role);

    boolean verifyToken(String token, String role);

}
