package com.redisexample.redisexample.repository;

import java.util.List;
import java.util.Map;

import com.redisexample.redisexample.models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private RedisTemplate<String, Users> redisTemplate;
    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, Users> template)
    {
        this.redisTemplate= template;
        this.hashOperations= template.opsForHash();
    }
    @Override
    public void createUser(Users user) {
        hashOperations.put("USER", user.getUserId(), user);
    }

    @Override
    public void deleteUser(String userId) {
        hashOperations.delete("USER", userId);

    }

    @Override
    public Map<String, Users> getAll() {
        // TODO Auto-generated method stub
        return hashOperations.entries("USER");
    }

    @Override
    public Users getUserById(String userId) {
        
        return (Users) hashOperations.get("USER", userId);
    }
    
}
