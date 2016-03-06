package main.java.atrotskov.service.impl;

import org.springframework.stereotype.Service;
import main.java.atrotskov.model.User;
import main.java.atrotskov.service.api.UserService;

import java.util.List;

/**
 * Created by jdev on 29.02.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
