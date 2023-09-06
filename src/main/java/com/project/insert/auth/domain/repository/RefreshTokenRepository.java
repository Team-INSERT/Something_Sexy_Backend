package com.project.insert.auth.domain.repository;

import com.project.insert.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken,String> {
    Optional<RefreshToken> findById(String authId);
}
