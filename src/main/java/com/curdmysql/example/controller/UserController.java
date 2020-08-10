package com.curdmysql.example.controller;

import java.util.List;

import com.curdmysql.example.entity.User;
import com.curdmysql.example.ro.UserRO;
import com.curdmysql.example.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody UserRO userRO){
        return userService.addUser(userRO);
    }

    @PutMapping(path = "/{userId}")
    public User updateUser(@PathVariable("userId") Long userId , @RequestBody UserRO userRO){
        logger.info("User ID = "+userId);
        return userService.updateUser(userId, userRO);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        logger.info("User ID = "+userId);
        userService.deleteUser(userId);
    }
}