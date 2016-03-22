package atrotskov.dao.impl;

import atrotskov.dao.api.ProductDao;
import atrotskov.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexey on 22.03.16.
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Product create(Product product) {
        Session sess = sessionFactory.getCurrentSession();
        sess.save(product);
        return product;
    }

    @Override
    public Product getById(long id) {
        Session sess = sessionFactory.getCurrentSession();
        return (Product) sess.get(Product.class, id);
    }

    @Override
    public boolean delete(Product product) {
        Session sess = sessionFactory.getCurrentSession();
        sess.delete(product);
        // idempotent realisation?
        return true;
    }

    @Override
    public Product update(Product product) {
        Session sess = sessionFactory.getCurrentSession();
        sess.update(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        Session sess = sessionFactory.getCurrentSession();
        return sess.createCriteria(Product.class).list();
    }
}
