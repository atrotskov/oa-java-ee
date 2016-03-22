package atrotskov.dao.impl;

import atrotskov.dao.api.OrderDao;
import atrotskov.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexey on 22.03.16.
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Order create(Order order) {
        Session sess = sessionFactory.getCurrentSession();
        sess.save(order);
        return order;
    }

    @Override
    public Order getById(long id) {
        Session sess = sessionFactory.getCurrentSession();
        return (Order) sess.get(Order.class, id);
    }

    @Override
    public boolean delete(Order order) {
        Session sess = sessionFactory.getCurrentSession();
        sess.delete(order);
        return true;
    }

    @Override
    public Order update(Order order) {
        Session sess = sessionFactory.getCurrentSession();
        sess.update(order);
        return order;
    }

    @Override
    public List<Order> getAll() {
        Session sess = sessionFactory.getCurrentSession();
        return sess.createCriteria(Order.class).list();
    }
}
