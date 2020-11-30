package com.spring.presentation.cosmos.dao.impl;

import com.spring.presentation.cosmos.dao.UserReactiveDao;
import com.spring.presentation.cosmos.dao.repository.UserReactiveRepository;
import com.spring.presentation.cosmos.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Repository
@Slf4j
public class UserReactiveDaoImpl implements UserReactiveDao {

    private UserReactiveRepository repository;

    @Override
    public Flux<User> getAll() {
        return repository.findAll()
                .doOnError(Throwable::printStackTrace)
                .doOnComplete(() -> log.info("Completado!"));
    }

    @Override
    public Mono<User> getById(String id) {
        return repository.findById(id)
                .doOnError(Throwable::printStackTrace)
                .doOnTerminate(() -> log.info("Búsqueda completada!"));
    }

    @Override
    public Mono<User> save(User user) {
        return repository.save(user)
                .doOnError(Throwable::printStackTrace)
                .doOnTerminate(() -> log.info("Guardado completado!"));
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id)
                .doOnError(Throwable::printStackTrace)
                .doOnTerminate(() -> log.info("Eliminación completada!"));
    }
}
