package com.mosaiker.authservice;

import com.mosaiker.authservice.service.TokenService;
import com.mosaiker.authservice.service.TokenServiceImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class TokenServiceTest {

    private TokenService tokenService = new TokenServiceImpl();

    private final static String header = "eyJhbGciOiJIUzUxMiJ9.";

    @Test
    public void createToken_success() {
        String result = tokenService.createToken("tbc", "admin");
        assertThat(result, startsWith(header));
    }

    @Test
    public void verifyToken_success() {
        String token = tokenService.createToken("tbc", "admin");
        boolean result = tokenService.verifyToken(token, "admin");
        assertThat(result, is(true));
    }

    @Test
    public void verifyToken_fail() {
        String token = tokenService.createToken("tbc", "admin");
        boolean result = tokenService.verifyToken(token, "customer");
        assertThat(result, is(false));
    }

}
