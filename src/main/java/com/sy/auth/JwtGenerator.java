package com.sy.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

public class JwtGenerator {
    public static void main(String[] args) {
        // Generate a key
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Encode the key as a Base64 string
        String keyString = encodeBase64(key.getEncoded());
//        String keyString = "jWkfzSduzhTGUotvhhtc2umPD+EcuIu13Tt82lDpbh0=";

        // Example user information
        String userId = "sy";
        String username = "suyoung";

        // Set token expiration time
        long expirationTimeMillis = System.currentTimeMillis() + 1000 * 60 * 60;

        // Generate the JWT token
        String token = Jwts.builder()
                .subject(userId)
                .claim("username", username)
                .claim("userId", userId)
                .expiration(new Date(expirationTimeMillis))
                .signWith(key)
                .compact();

        // Print the generated token
        System.out.println("key:" + keyString);
        System.out.println("Generated Token: " + token);

    }
    private static String encodeBase64(byte[] keyBytes) {
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}