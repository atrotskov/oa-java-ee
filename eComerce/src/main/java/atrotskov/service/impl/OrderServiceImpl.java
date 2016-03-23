package atrotskov.service.impl;

import atrotskov.dao.api.OrderDao;
import atrotskov.model.Order;
import atrotskov.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexey on 22.03.16.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    @Transactional
    public Order create(Order order) {
        return orderDao.create(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(long id) {
        return orderDao.getById(id);
    }

    @Override
    @Transactional
    public boolean delete(Order order) {
        return orderDao.delete(order);
    }

    @Override
    @Transactional
    public Order update(Order order) {
        return orderDao.update(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
