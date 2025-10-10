package dam.proy.ticketing.app.security;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("bR8s#AqM!zJ9e@Y7uV6wLkPcQxTn1234".getBytes());

     /*Generar un token con el email. Le esta diciendo el email que esta logeando, fecha de cuando se genera el token, lo que durara ese token (en este caso
    hemos puesto 1 dia) y el algoritmo y la clave secreta.*/

    public String generarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    //Obtenemos el email de el token que hemos generado

    public String obtenerEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validamos si el token es correcto y no ha caducado

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
