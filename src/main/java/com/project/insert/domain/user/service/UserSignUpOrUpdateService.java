package com.project.insert.domain.user.service;

import com.project.insert.domain.exception.UserNotFoundException;
import com.project.insert.domain.user.User;
import com.project.insert.domain.user.authority.Authority;
import com.project.insert.domain.user.repository.UserRepository;
import com.project.insert.global.annotation.ServiceWithTransactionalReadOnly;
import com.project.insert.global.oauth.exception.BsmAuthIdInvalidClientException;
import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.response.BsmResourceResponse;
import leehj050211.bsmOauth.exceptions.BsmAuthCodeNotFoundException;
import leehj050211.bsmOauth.exceptions.BsmAuthInvalidClientException;
import leehj050211.bsmOauth.exceptions.BsmAuthTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@ServiceWithTransactionalReadOnly
public class UserSignUpOrUpdateService {
    private final BsmOauth bsmOauth;
    private final UserRepository userRepository;

    public User excute(String authId) throws IOException {
        String token;
        BsmResourceResponse resource;

        try {
            token = bsmOauth.getToken(authId);
            resource = bsmOauth.getResource(token);
        } catch (BsmAuthCodeNotFoundException | BsmAuthTokenNotFoundException e) {
            throw UserNotFoundException.EXCEPTION;
        } catch (BsmAuthInvalidClientException e) {
            throw BsmAuthIdInvalidClientException.EXCEPTION;
        }

        return updateOrSignUp(resource);
    }

    @Transactional
    public User updateOrSignUp(BsmResourceResponse resource) {
        Optional<User> user = userRepository.findByEmail(resource.getEmail());
        if(user.isEmpty()) {
            return saveUser(resource);
        }
        User updateUser = user.get();
        return updateUser.update(resource);
    }

    @Transactional
    public User saveUser(BsmResourceResponse response) {
        return userRepository.save(
            User.builder()
            .email(response.getEmail())
            .nickname(response.getNickname())
            .authority(Authority.USER)
            .build()
            );
    }
}
