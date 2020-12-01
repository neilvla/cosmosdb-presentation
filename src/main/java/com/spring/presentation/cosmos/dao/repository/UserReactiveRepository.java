package com.spring.presentation.cosmos.dao.repository;

import com.azure.spring.data.cosmos.repository.Query;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.spring.presentation.cosmos.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserReactiveRepository extends ReactiveCosmosRepository<User, String> {

    Flux<User> getUsersByLastName(String lastName);

    Flux<User> getAllByLastName(String lastName);

    Flux<User> findAllByName(String lastName);

    @Query("SELECT * FROM Users u")
    Flux<User> allNames();

    @Query("SELECT * FROM Users u where u.id=@id")
    Mono<User> byId(String id);

}
