package atrotskov.dao.impl;

import atrotskov.dao.api.UserDao;
import atrotskov.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jdev on 29.02.2016.
 */
@Repository
public class UserDaoHiberImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        Session sess = null;
        sess = sessionFactory.getCurrentSession();
        sess.save(user);
        return user;
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
