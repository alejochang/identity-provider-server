package com.alejochang.service;

import com.alejochang.model.AuthToken;

/**
 * Created by achang on 6/22/16.
 */
public interface UserService {

    AuthToken authenticate(String username, String password);

    Boolean validateToken(AuthToken token);

    void invalidateToken(AuthToken token);
}
