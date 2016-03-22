package atrotskov.service.api;

import atrotskov.model.Order;

import java.util.List;

/**
 * Created by alexey on 21.03.16.
 */
public interface OrderService {
    Order create(Order order);

    Order getById(long id);

    boolean delete(Order order);

    Order update(Order order);

    List<Order> getAll();
}
