package com.spring.presentation.cosmos.dao;

import com.spring.presentation.cosmos.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserReactiveDao {

    Flux<User> getAll();

    Mono<User> getById(String id);

    Mono<User> save(User user);

    Mono<Void> deleteById(String id);

}
