package com.example.greenpotback.Security;

import com.example.greenpotback.User.User;
import com.example.greenpotback.User.UserServiceImp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

@Component
@AllArgsConstructor
public class TokenProvider {

    private final UserServiceImp userService;
    public String generateAccessToken(String email){
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + SecurityConst.JWT_ACCESS_EXPIR_TIME);

        User user = userService.findUserByEmail(email);

        return SecurityConst.JWT_TOKEN_TYPE +
                Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .claim("roles", Collections.singletonList(user.getRole().getName()))
                .signWith(SignatureAlgorithm.HS512, SecurityConst.JWT_SECRET)
                .compact();
    }

    public String generateRefreshToken(String email) {
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + SecurityConst.JWT_REFRESH_EXPIR_TIME);

        return SecurityConst.JWT_TOKEN_TYPE +
                Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConst.JWT_SECRET)
                .compact();
    }

    public String getEmailFromJWT (String token){
        return Jwts.parser()
                .setSigningKey(SecurityConst.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SecurityConst.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Given JWT is expired or incorrect");
        }
    }
}
