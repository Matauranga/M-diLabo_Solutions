package com.mediLaboSolutions.gatewaymanagement.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    /**
     * The secret key used for JWT signing and validation.
     *
     */
    //TODO: Frank
    @Value("${jwt.secret}")
    private String SECRET;

    /**
     * Validates the given JWT token.
     *
     * @param token the JWT token to validate
     */
    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    /**
     * Retrieves the signing key used for JWT operations.
     *
     * @return the signing key
     */
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}