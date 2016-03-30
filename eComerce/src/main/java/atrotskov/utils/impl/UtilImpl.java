package atrotskov.utils.impl;

import atrotskov.model.Category;
import atrotskov.service.api.CategoryService;
import atrotskov.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexey on 30.03.16.
 */
@Component
public class UtilImpl implements Util {

    @Autowired
    CategoryService categoryService;

    public List<String> getListOfCatName() {
        List<Category> categories;
        List<String> listForSelect = new ArrayList<>();
        listForSelect.add(""); // Чтобы первый элемент в селекте формы был пустым
        categories = categoryService.getAll();
        for (Category category : categories) {
            listForSelect.add(category.getName());
        }
        return listForSelect;
    }
}
