//package com.example.demo.security_config;
//
//import io.jsonwebtoken.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//@Slf4j
//public class JwtTokenProvider {
//
//    @Value("${application.jwt_secret}")
//    private String JWT_SECRET;
//
//    @Value("${application.access_token_expired}")
//    private long accessTokenExpired;
//
//    public String generateToken(CustomUserDetails userDetails) {
//        Date now = new Date();
//        Date expiredDate = new Date(now.getTime() + accessTokenExpired * 60 * 1000); //to milisecond
//
//        return Jwts.builder()
//                .setSubject(Long.toString(userDetails.getUser().getId()))
//                .setIssuedAt(now)
//                .setExpiration(expiredDate)
//                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//                .compact();
//    }
//
//    public Long getUserIdFromJWT(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(JWT_SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return Long.parseLong(claims.getSubject());
//    }
//
//    public boolean validateToken(String token) {
//
//        try {
//            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
//        } catch (MalformedJwtException e) {
//            log.error("Invalid token");
//        } catch (ExpiredJwtException e) {
//            log.error("Expired token");
//        } catch (UnsupportedJwtException e) {
//            log.error("Unsupported JWT");
//        } catch (IllegalArgumentException e) {
//            log.error("JWT claims string is empty.");
//        }
//        return false;
//    }
//}
