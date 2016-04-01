package atrotskov.dao.impl;

import atrotskov.dao.api.ProductDao;
import atrotskov.model.Category;
import atrotskov.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Product getByName(String name) {
        return (Product) sessionFactory.getCurrentSession().
                createCriteria(Product.class).
                add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Override
    public boolean addProductToCategory(Product product, Category category) {
        Set<Category> categs = new HashSet<>();
        categs = product.getCategories();
        categs.add(category);
        Session sess = sessionFactory.getCurrentSession();
        Product product1 = (Product) sess.get(Product.class, product.getId());
        product1.setCategories(categs);
        return true;
    }
}
