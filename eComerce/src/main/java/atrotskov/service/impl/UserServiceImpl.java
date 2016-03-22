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


    @Override
    @Transactional
    public User create(User user) {
        return userDao.create(user);
    }


    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.getById(id);
    }


    @Override
    @Transactional
    public boolean delete(User user) {
        return userDao.delete(user);
    }


    @Override
    @Transactional
    public User update(User user) {
        return userDao.update(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
