package com.spring.presentation.cosmos.dao.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.spring.presentation.cosmos.entity.User;

public interface UserRepository extends CosmosRepository<User, String> {
}
