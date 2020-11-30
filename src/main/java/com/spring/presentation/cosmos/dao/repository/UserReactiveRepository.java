package com.spring.presentation.cosmos.dao.repository;

import com.azure.spring.data.cosmos.repository.Query;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.spring.presentation.cosmos.entity.User;
import reactor.core.publisher.Flux;

public interface UserReactiveRepository extends ReactiveCosmosRepository<User, String> {

    Flux<User> getUsersByLastName(String lastName);

    Flux<User> getAllByLastName(String lastName);

    @Query("select * from Users u where u.lastName = @lastName")
    Flux<User> allByLastName(String lastName);
}
