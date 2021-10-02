package com.springredis.springredis.dao;

import com.springredis.springredis.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo {
    boolean saveUser(UserEntity userEntity);

    List<UserEntity> fetchAllUser();

    UserEntity fetchUserById(int id);

    boolean deleteById(int id);
}
