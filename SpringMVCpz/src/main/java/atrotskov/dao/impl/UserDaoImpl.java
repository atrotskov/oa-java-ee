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
public class UserDaoImpl implements UserDao {
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
        Session sess = null;
        sess = sessionFactory.getCurrentSession();
        return (User) sess.get(User.class, id);
    }

    @Override
    public boolean delete(User user) {
        Session sess = null;
        sess = sessionFactory.getCurrentSession();
        sess.delete(user);
        return true;
    }

    @Override
    public User update(User user) {
        Session sess = null;
        sess = sessionFactory.getCurrentSession();
        sess.update(user);
        return (User) sess.get(User.class, user.getId());
    }

    @Override
    public List<User> getAll() {
        Session sess = null;
        sess = sessionFactory.getCurrentSession();
        return sess.createCriteria(User.class).list();
    }
}
