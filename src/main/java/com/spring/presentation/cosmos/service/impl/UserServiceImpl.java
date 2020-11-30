package com.spring.presentation.cosmos.service.impl;

import com.spring.presentation.cosmos.dao.UserDao;
import com.spring.presentation.cosmos.entity.User;
import com.spring.presentation.cosmos.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserDao dao;

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User getById(String id) {
        return dao.getById(id);
    }

    @Override
    public User create(User user) {
        return dao.save(user);
    }

    @Override
    public User update(User user, String id) {
        User u = this.getById(id);
        u.setName(user.getName());
        u.setLastName(user.getLastName());
        return dao.save(u);
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }
}
