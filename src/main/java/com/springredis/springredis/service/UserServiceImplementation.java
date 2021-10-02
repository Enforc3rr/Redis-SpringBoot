package com.springredis.springredis.service;

import com.springredis.springredis.dao.UserRepo;
import com.springredis.springredis.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean saveUser(UserEntity userEntity) {
        return userRepo.saveUser(userEntity);
    }

    @Override
    public List<UserEntity> fetchAllUser() {
        return userRepo.fetchAllUser();
    }

    @Override
    public UserEntity fetchUserById(int id) {
        return userRepo.fetchUserById(id);
    }

    @Override
    public boolean deleteById(int id) {
        return userRepo.deleteById(id);
    }


}
