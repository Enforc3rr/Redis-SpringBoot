package com.springredis.springredis.controller;

import com.springredis.springredis.entity.UserEntity;
import com.springredis.springredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody UserEntity userEntity){
        boolean result = userService.saveUser(userEntity);
        if(result){
            return ResponseEntity.ok("User Created Successfully");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserEntity>> fetchAllUser(){
        List<UserEntity> userEntities;
        userEntities = userService.fetchAllUser();
        return ResponseEntity.ok(userEntities);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable int id){
        return new ResponseEntity<>(userService.fetchUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        if(userService.deleteById(id)){
            return ResponseEntity.ok("Deleted");
        }else{
            return ResponseEntity.ok("Not Deleted");
        }
    }

}
