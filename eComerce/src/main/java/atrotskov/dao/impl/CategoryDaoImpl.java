package atrotskov.dao.impl;

import atrotskov.dao.api.CategoryDao;
import atrotskov.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexey on 22.03.16.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Category create(Category category) {
        Session sess = sessionFactory.getCurrentSession();
        sess.save(category);
        return category;
    }

    @Override
    public Category getById(long id) {
        Session sess = sessionFactory.getCurrentSession();
        return (Category) sess.get(Category.class, id);
    }

    @Override
    public boolean delete(Category category) {
        Session sess = sessionFactory.getCurrentSession();
        sess.delete(category);
        return true;
    }

    @Override
    public Category update(Category category) {
        Session sess = sessionFactory.getCurrentSession();
        sess.update(category);
        return category;
    }

    @Override
    public List<Category> getAll() {
        Session sess = sessionFactory.getCurrentSession();
        return sess.createCriteria(Category.class).list();
    }
}
