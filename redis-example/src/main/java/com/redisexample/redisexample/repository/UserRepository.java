package com.redisexample.redisexample.repository;


import java.util.Map;

import com.redisexample.redisexample.models.Users;

public interface UserRepository {

    void createUser(Users user);
    void deleteUser(String userId);
    Map<String, Users> getAll();
    Users getUserById(String userId);
}
