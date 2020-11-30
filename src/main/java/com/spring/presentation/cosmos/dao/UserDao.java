package com.spring.presentation.cosmos.dao;

import com.spring.presentation.cosmos.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    User getById(String id);

    User save(User user);

    void deleteById(String id);

}
