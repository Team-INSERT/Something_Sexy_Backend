package com.project.insert.global.jwt;

import com.project.insert.domain.auth.domain.RefreshToken;
import com.project.insert.domain.auth.domain.repository.RefreshTokenRepository;
import com.project.insert.global.jwt.dto.TokenResponseDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import static com.project.insert.global.jwt.JwtConstants.*;

@RequiredArgsConstructor
@Component
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponseDto generateToken(String authId,String role) {
        String accessToken = jwtProperties.getPrefix() + EMPTY.getMessage() + generateToken(authId,role,ACCESS_KEY.getMessage(),jwtProperties.getAccessExp());
        String refreshToken = jwtProperties.getPrefix() + EMPTY.getMessage() + generateToken(authId, role, REFRESH_KEY.getMessage() ,jwtProperties.getRefreshExp());

        refreshTokenRepository.save(RefreshToken.builder()
                .id(authId)
                .refreshToken(refreshToken)
                .ttl(jwtProperties.getRefreshExp() * 1000)
                .build()
        );

        return new TokenResponseDto(accessToken, refreshToken, getExpiredTime());
    }

    private String generateToken(String authId,String role,String type,Long time) {
        return Jwts.builder()
                .setSubject(authId)
                .setHeaderParam(TYPE.message,type)
                .claim(AUTH_ID.message, authId)
                .claim(ROLE.message, role)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }

    private ZonedDateTime getExpiredTime(){
        return ZonedDateTime.now().plusSeconds(jwtProperties.getRefreshExp());
    }
}
