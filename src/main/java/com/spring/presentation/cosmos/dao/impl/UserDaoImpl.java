package com.spring.presentation.cosmos.dao.impl;

import com.spring.presentation.cosmos.dao.UserDao;
import com.spring.presentation.cosmos.dao.repository.UserRepository;
import com.spring.presentation.cosmos.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    private UserRepository repository;

    @Override
    public List<User> getAll() {
        List<User> users = null;
        try {
            users = new ArrayList<>();
            repository.findAll().forEach(users::add);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            log.info("Finalizado!");
        }
        return users;
    }

    @Override
    public User getById(String id) {
        User u = null;
        try {
            u = repository.findById(id).get();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            log.info("Búsqueda completada!");
        }
        return u;
    }

    @Override
    public User save(User user) {
        User u = null;
        try {
            u = repository.save(user);

        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
        } finally {
            log.info("Guardado completado!");
        }
        return u;
    }

    @Override
    public void deleteById(String id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
        } finally {
            log.info("Eliminación completada!");
        }
    }
}
