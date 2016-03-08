package atrotskov.service.impl;

import atrotskov.dao.api.UserDao;
import atrotskov.model.User;
import atrotskov.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jdev on 29.02.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Transactional
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
