package com.springredis.springredis.dao;

import com.springredis.springredis.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepoImplementation implements UserRepo {
    @Autowired
    private RedisTemplate redisTemplate;

    //Spring uses Hash Property of Redis to work with
    private static final String KEY = "User";


    @Override
    public boolean saveUser(UserEntity userEntity) {
        try{
            redisTemplate.opsForHash().put(KEY,userEntity.getId(),userEntity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserEntity> fetchAllUser() {
        return (List<UserEntity>) redisTemplate.opsForHash().values(KEY);
    }
    @Override
    public UserEntity fetchUserById(int id){
        return (UserEntity) redisTemplate.opsForHash().get(KEY,id);
    }

    @Override
    public boolean deleteById(int id){
        try{
            redisTemplate.opsForHash().delete(KEY,id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
