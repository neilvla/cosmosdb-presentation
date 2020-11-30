package com.spring.presentation.cosmos.dao.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.spring.presentation.cosmos.entity.User;

public interface UserReactiveRepository extends ReactiveCosmosRepository<User, String> {
}
