package atrotskov.service.api;

import atrotskov.model.Category;

import java.util.List;

/**
 * Created by alexey on 21.03.16.
 */
public interface CategoryService {
    Category create(Category category);

    Category getById(long id);

    boolean delete(Category category);

    Category update(Category category);

    List<Category> getAll();
}
