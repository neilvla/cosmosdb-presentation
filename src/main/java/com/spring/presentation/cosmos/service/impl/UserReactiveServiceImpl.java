package com.spring.presentation.cosmos.service.impl;

import com.spring.presentation.cosmos.dao.UserReactiveDao;
import com.spring.presentation.cosmos.entity.User;
import com.spring.presentation.cosmos.service.UserReactiveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UserReactiveServiceImpl implements UserReactiveService {

    private UserReactiveDao reactiveDao;

    @Override
    public Flux<User> getAll() {
        return reactiveDao.getAll();
    }

    @Override
    public Mono<User> getById(String id) {
        return reactiveDao.getById(id);
    }

    @Override
    public Mono<User> create(User user) {
        return reactiveDao.save(user);
    }

    @Override
    public Mono<User> update(User user, String id) {
        return reactiveDao.getById(id).flatMap(u -> {
            u.setName(user.getName());
            u.setLastName(user.getLastName());
            return reactiveDao.save(u);
        });
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return reactiveDao.deleteById(id);
    }
}
