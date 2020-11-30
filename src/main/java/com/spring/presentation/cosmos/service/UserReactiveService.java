package com.spring.presentation.cosmos.service;

import com.spring.presentation.cosmos.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserReactiveService {

    Flux<User> getAll();

    Mono<User> getById(String id);

    Mono<User> create(User user);

    Mono<User> update(User user, String id);

    Mono<Void> deleteById(String id);

}
