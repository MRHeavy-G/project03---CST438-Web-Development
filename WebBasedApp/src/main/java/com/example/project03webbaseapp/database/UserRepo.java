package com.example.project03webbaseapp.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>{



    User findUserByUsername(String username);


    User findUserByUserId(Integer userId);

    Boolean existsUserByUsername(String username);





}
