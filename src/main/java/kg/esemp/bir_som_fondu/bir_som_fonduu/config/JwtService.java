package kg.esemp.bir_som_fondu.bir_som_fonduu.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import kg.esemp.bir_som_fondu.bir_som_fonduu.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final Key secretKey;

    public JwtService(@Value("${jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // Метод для генерации JWT токена
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())  // Указываем уникальный идентификатор пользователя
                .setIssuedAt(new Date())  // Дата выпуска токена
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // Срок действия (1 час)
                .signWith(secretKey, SignatureAlgorithm.HS256)  // Подписываем токен ключом
                .compact();
    }

    // Метод для валидации токена
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;  // Токен валиден
        } catch (JwtException e) {
            return false;  // Ошибка валидации
        }
    }

    // Метод для извлечения username из токена
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}


