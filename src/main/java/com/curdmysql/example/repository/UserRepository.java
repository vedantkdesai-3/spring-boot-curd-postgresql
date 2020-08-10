package com.curdmysql.example.repository;

import com.curdmysql.example.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    
}