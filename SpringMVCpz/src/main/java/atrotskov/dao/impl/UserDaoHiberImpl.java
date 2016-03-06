package main.java.atrotskov.dao.impl;

import main.java.atrotskov.dao.api.UserDao;
import main.java.atrotskov.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jdev on 29.02.2016.
 */
@Repository
public class UserDaoHiberImpl implements UserDao {
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
