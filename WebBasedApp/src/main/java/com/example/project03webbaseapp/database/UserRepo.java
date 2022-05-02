package com.example.project03webbaseapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer>{

    User finderUserByUsername(String username);

    User findUserByUserId(Integer userId);

    Boolean existsUserByUsername(String username);


}