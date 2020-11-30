package com.spring.presentation.cosmos.controller;

import com.spring.presentation.cosmos.entity.User;
import com.spring.presentation.cosmos.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserService service;

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable("id") String id) {
        return service.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
    }

}
