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
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public User create(User user) {
        return userDao.create(user);
    }


    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }


    @Override
    public boolean delete(User user) {
        return userDao.delete(user);
    }


    @Override
    public User update(User user) {
        return userDao.update(user);
    }


    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
