package com.redisexample.redisexample.controllers;

import com.redisexample.redisexample.models.Users;
import com.redisexample.redisexample.repository.UserRepository;
import com.redisexample.redisexample.repository.UserRepositoryImpl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserRepositoryImpl userRepository;

    @RequestMapping(value = "/getUser/{userID}", method = RequestMethod.GET)
    Users getUser(@PathVariable("userID") String userID)
    {       
        Users user= userRepository.getUserById(userID);
        return user;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello()
    {
        return "Hello";
    }

    @RequestMapping(value="/save/{userID}/{userName}", method = RequestMethod.GET)
    String saveUser(@PathVariable("userID") String userID, @PathVariable("userName") String userName)
    {
        userRepository.createUser(new Users(userID, userName));
        return "User saved";
    }

    
}
