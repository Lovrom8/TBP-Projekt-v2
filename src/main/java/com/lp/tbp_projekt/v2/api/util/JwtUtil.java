package com.lp.tbp_projekt.v2.api.util;

import com.lp.tbp_projekt.v2.api.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil
{
    @Autowired
    private final UserRepository userRepository;

    final private String SECRET_KEY = "UmVhbGx5RnJla2FpbmdTZWNyZXRLZXlOb3RSZWFsbHkxMDIzMjMyMzI=";

    public JwtUtil(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public String validateAndExtractID(String token)
    {
        return (String)extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String ID)
    {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims).setSubject(ID).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token)
    {
        final String ID = validateAndExtractID(token);
        return (userRepository.findById(ID).isPresent() && !isTokenExpired(token));
    }
}