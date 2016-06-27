package com.alejochang.repository;

import com.alejochang.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by achang on 6/20/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    @CacheEvict(value = "users", allEntries = true)
    User save(User entity);

    @Override
    @CacheEvict(value = "users", allEntries = true)
    void delete(Long id);

    @Cacheable(value = "users")
    User findByUsername(String username);

    @Cacheable("users")
    List<User> findByEnabled(Boolean enabled, Pageable pageable);

}
