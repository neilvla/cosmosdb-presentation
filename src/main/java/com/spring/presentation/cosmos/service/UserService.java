package com.spring.presentation.cosmos.service;

import com.spring.presentation.cosmos.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(String id);

    User create(User user);

    User update(User user, String id);

    void deleteById(String id);

}
