package com.project.insert.domain.user.service;

import com.project.insert.domain.auth.domain.RefreshToken;
import com.project.insert.domain.auth.domain.repository.RefreshTokenRepository;
import com.project.insert.domain.user.User;
import com.project.insert.global.annotation.ServiceWithTransactionalReadOnly;
import com.project.insert.global.jwt.JwtProperties;
import com.project.insert.global.jwt.JwtProvider;
import com.project.insert.global.jwt.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class UserLoginService {
    private final UserSignUpOrUpdateService userSignUpOrUpdateService;
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Transactional
    public TokenResponseDto execute(String authId) throws IOException {
        User user = userSignUpOrUpdateService.execute(authId);

        return saveRefreshToken(jwtProvider.generateToken(user.getEmail(), user.getAuthority().name()), user.getEmail());
    }

    @Transactional
    protected TokenResponseDto saveRefreshToken(TokenResponseDto tokenResponseDto, String id){
        refreshTokenRepository.save(
                RefreshToken.builder()
                        .id(id)
                        .refreshToken(tokenResponseDto.getRefreshToken())
                        .ttl(jwtProperties.getRefreshExp() * 1000)
                        .build()

        );
        return tokenResponseDto;
    }
}
