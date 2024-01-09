package com.mediLaboSolutions.gatewaymanagement.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    public static final String SECRET = "QicO2Lma84FRkfXtMDUMalt8B3e1LU7ePvAPmXA6BX2ElQGHqTm3iB4IrqvHspxJBaxLhVvc0kZXYAwB3yzNjHStOL5H241FKodOpwqxw7ez9v3FquEz5bDoNiz0IOiV";

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }


    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}