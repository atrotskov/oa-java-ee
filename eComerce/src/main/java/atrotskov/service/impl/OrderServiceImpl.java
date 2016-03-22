package atrotskov.service.impl;

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
    OrderService orderService;

    @Override
    @Transactional
    public Order create(Order order) {
        return orderService.create(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(long id) {
        return orderService.getById(id);
    }

    @Override
    @Transactional
    public boolean delete(Order order) {
        return orderService.delete(order);
    }

    @Override
    @Transactional
    public Order update(Order order) {
        return orderService.update(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return orderService.getAll();
    }
}
