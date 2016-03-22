package atrotskov.service.impl;

import atrotskov.model.Category;
import atrotskov.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexey on 22.03.16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryService categoryService;

    @Override
    @Transactional
    public Category create(Category category) {
        return categoryService.create(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Category getById(long id) {
        return categoryService.getById(id);
    }

    @Override
    @Transactional
    public boolean delete(Category category) {
        return categoryService.delete(category);
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return categoryService.update(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}
