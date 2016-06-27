package com.alejochang.repository;

import com.alejochang.model.AuthToken;
import com.alejochang.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by achang on 6/20/16.
 */
public interface AuthTokenRepository extends CrudRepository<AuthToken, Long> {

    @Override
    AuthToken save(AuthToken entity);

    @Override
    void delete(Long id);

    AuthToken findByUsername(String username);

}
