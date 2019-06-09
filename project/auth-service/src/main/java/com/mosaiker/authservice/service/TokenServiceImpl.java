package com.mosaiker.authservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService{

    static final long EXPIRATIONTIME = 60 * 60 * 1000;      //1 hour
    static final String SECRET = "mosaiker";            // JWT密码
    static final String TOKEN_PREFIX = "Bearer ";        // Token前缀

    @Override
    public String createToken(String username, String role) {
        String token = Jwts.builder()
                // 保存权限（角色）
                .claim("authorities", role)
                // 用户名写入标题
                .setSubject(username)
                // 有效期设置
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                // 签名设置
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return token;
    }

    @Override
    public boolean verifyToken(String token, String role) {
        // 解析 Token
        Claims claims = Jwts.parser()
                // 验签
                .setSigningKey(SECRET)
                // 去掉 Bearer
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();

        // 要求的身份和 token 中含有的身份信息匹配，返回 true
        return role.equals(claims.get("authorities"));
    }

}
