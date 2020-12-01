package com.spring.presentation.cosmos.controller;

import com.spring.presentation.cosmos.entity.User;
import com.spring.presentation.cosmos.service.UserReactiveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("user-reactive")
public class UserReactiveController {

    private UserReactiveService reactiveService;

    @GetMapping
    public Flux<User> getAll() {
        return reactiveService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable("id") String id) {
        return reactiveService.getById(id);
    }

    @PostMapping
    public Mono<User> create(@RequestBody User user) {
        return reactiveService.create(user);
    }

    @PutMapping("/{id}")
    public Mono<User> update(@RequestBody User user, @PathVariable("id") String id) {
        return reactiveService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return reactiveService.deleteById(id);
    }

}
