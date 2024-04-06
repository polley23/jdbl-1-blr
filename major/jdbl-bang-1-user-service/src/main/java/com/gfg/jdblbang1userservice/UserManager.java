package com.gfg.jdblbang1userservice;

import com.gfg.jdblbang1userservice.entity.SignUp;
import com.gfg.jdblbang1userservice.entity.UserResponse;
import org.springframework.stereotype.Service;

public interface UserManager {
    void createUser(SignUp signUp);
    UserResponse getUser(String username) throws Exception;
}
