package atrotskov.service.api;

import atrotskov.model.Product;

import java.util.List;

/**
 * Created by alexey on 21.03.16.
 */
public interface ProductService {
    Product create(Product product);

    Product getById(long id);

    boolean delete(Product product);

    Product update(Product product);

    List<Product> getAll();
}
