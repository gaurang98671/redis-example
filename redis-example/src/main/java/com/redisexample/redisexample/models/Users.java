package com.redisexample.redisexample.models;

public class Users {

    private String name;
    private String userId;

    public Users(String userID, String name)
    {
        this.userId= userID;
        this.name= name;
    }

    public String getName() {
        return name;
    }
    public String getUserId() {
        return userId;
    }

    
}
