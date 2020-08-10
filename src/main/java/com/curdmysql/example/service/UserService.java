package com.curdmysql.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.curdmysql.example.entity.User;
import com.curdmysql.example.repository.UserRepository;
import com.curdmysql.example.ro.UserRO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional(value = TxType.SUPPORTS)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional(value = TxType.REQUIRED)
    public User addUser(UserRO userRO){
        User user = new User(userRO.getId(),userRO.getName(),userRO.getAddress());
        return userRepository.save(user);
    }

    @Transactional(value = TxType.REQUIRED)
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    @Transactional(value = TxType.REQUIRED)
    public User updateUser(Long userId,UserRO userRO){
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            user.setName(userRO.getName());
            user.setAddress(userRO.getAddress());
            return userRepository.save(user);
        }else{
            return null;
        }
    }
    
}