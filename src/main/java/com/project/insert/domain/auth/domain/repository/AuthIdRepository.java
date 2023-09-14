package com.project.insert.domain.auth.domain.repository;

import com.project.insert.domain.auth.domain.AuthId;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

public interface AuthIdRepository extends CrudRepository<AuthId,String> {
    AuthId findByAuthId(String authId);
}
