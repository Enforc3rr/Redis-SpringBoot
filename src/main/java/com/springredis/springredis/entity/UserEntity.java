package com.springredis.springredis.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@RedisHash("User") //Defines the name of Hash/Object in Redis
/*
    Serializable interface allows java to save the object in serialized form .
    And
    To serialize an object means to convert its state to a byte stream so that the byte stream can
    be reverted back into a copy of the object.
 */
public class UserEntity implements Serializable {
    @Id
    private int id;

    private String username;
    private String password;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
