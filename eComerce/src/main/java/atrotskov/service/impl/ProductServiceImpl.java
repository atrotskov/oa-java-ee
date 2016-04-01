package atrotskov.service.impl;

import atrotskov.dao.api.ProductDao;
import atrotskov.model.Category;
import atrotskov.model.Product;
import atrotskov.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexey on 22.03.16.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(long id) {
        return productDao.getById(id);
    }

    @Override
    @Transactional
    public boolean delete(Product product) {
        return productDao.delete(product);
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getByName(String name) {
        return productDao.getByName(name);
    }

    @Override
    @Transactional
    public boolean addProductToCategory(Product product, Category category) {
        productDao.addProductToCategory(product, category);
        return true;
    }
}
