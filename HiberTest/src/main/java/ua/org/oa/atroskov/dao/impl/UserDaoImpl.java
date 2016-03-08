package ua.org.oa.atroskov.dao.impl;

/**
 * Created by jdev on 17.02.2016.
 */
import ua.org.oa.atroskov.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;
}