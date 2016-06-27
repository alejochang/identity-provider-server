package com.alejochang.service;

import com.alejochang.model.AuthToken;
import com.alejochang.model.User;
import com.alejochang.repository.AuthTokenRepository;
import com.alejochang.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by achang on 6/22/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory
            .getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Override
    public AuthToken authenticate(String username, String password) {
        User user =  userRepository.findByUsername(username);
        if(user !=null && user.getPassword().equals(password)){
            AuthToken newToken = new AuthToken(username, password);
            newToken.setActive(true);
            newToken.setCreationDate(Calendar.getInstance().getTime());
            newToken = authTokenRepository.save(newToken);
            return newToken;
        }
        return null;
    }

    @Override
    public Boolean validateToken(AuthToken token) {
        AuthToken validatedToken = authTokenRepository.findByUsername(token.getUsername());
        if(validatedToken != null){
            return validatedToken.getKey().equals(token.getKey());
        }else{
            return false;
        }
    }

    @Override
    public void invalidateToken(AuthToken token) {

    }
}
