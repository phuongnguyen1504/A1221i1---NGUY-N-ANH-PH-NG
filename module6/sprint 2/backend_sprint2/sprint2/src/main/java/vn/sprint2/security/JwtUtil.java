package vn.sprint2.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Date;
@Component
public class JwtUtil {
    private static final long EXPIRE_DURATION=24*60*60*1000L;//Quy đổi thời gian hết hạn ra ms
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);
    @Value("${app.jwt.secret}")
    private String SECRET_KEY;
    public String generateAccessToken(String username){
        return Jwts.builder().
                setSubject(username).
                setIssuedAt(new Date()).
                setExpiration(new Date((new Date()).getTime() + EXPIRE_DURATION)).
                signWith(SignatureAlgorithm.HS512, this.SECRET_KEY.getBytes(Charset.forName("UTF-8"))).
                compact();
    }
    public boolean validateAccessToken(String authToken){
        try {
            Jwts.parser().setSigningKey(this.SECRET_KEY.getBytes()).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token is unsupported: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT token: {}", e.getMessage());
        } catch (SignatureException e) {
            LOGGER.error("Invalid JWT signature: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
    public String getUsernameFromToken(String token){
        return this.parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser().setSigningKey(this.SECRET_KEY.getBytes(Charset.forName("UTF-8"))).parseClaimsJws(token.replace("{", "").replace("}", "")).getBody();
    }


}
