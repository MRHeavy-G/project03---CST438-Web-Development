package com.example.project03webbaseapp.database;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>{


    User testUSer = new User("user1","user1","user1","user1","user1");

    public static User findUserByUsername(String username) {
        return testUSer;
    }

    User findUserByUserId(Integer userId);

     Boolean existsUserByUsername(String username);

}
