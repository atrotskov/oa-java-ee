package atrotskov.controller;

import atrotskov.dto.CategoryDto;
import atrotskov.model.Category;
import atrotskov.service.api.CategoryService;
import atrotskov.transformer.Transformer;
import atrotskov.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexey on 29.03.16.
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    Transformer transformer;

    @Autowired
    Util util;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getAllCategories(ModelMap model) {
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (Category category : categoryService.getAll()) {
            categoriesDto.add(transformer.transformTo(category));
        }
        model.addAttribute("categoriesList", categoriesDto);
        return "categories";
    }

    @RequestMapping(value = "/category/admin", method = RequestMethod.GET)
    public String getAllCategoriesAdmin(ModelMap model) {
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (Category category : categoryService.getAll()) {
            categoriesDto.add(transformer.transformTo(category));
        }
        model.addAttribute("categoryList", categoriesDto);
        return "categoryAdmin";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.GET)
    public String addCategoryForm(ModelMap model) {
        List<String> listForSelect = util.getListOfCatName();
        model.addAttribute("nameList", listForSelect);
        return "addCategoryForm";
    }

    @RequestMapping(value = "/category/add/action", method = RequestMethod.POST)
    public String addCategory(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("parent-name") String parentName) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(name);
        categoryDto.setDesc(description);
        Category res = categoryService.getByName(parentName);
        if (res != null) {
            categoryDto.setParentId(res.getId());
        }
        long id = categoryService.create(transformer.transformTo(categoryDto)).getId();
        return "redirect:/category/update/" + id;
    }

    @RequestMapping(value = "/category/update/{id}", method = RequestMethod.GET)
    public String updateCategoryForm(@PathVariable("id") long id, ModelMap model) {
        CategoryDto categoryDto = transformer.transformTo(categoryService.getById(id));
        model.addAttribute("category", categoryDto);
        List<String> listForSelect = util.getListOfCatName();
        model.addAttribute("nameList", listForSelect);
        String parentName = categoryService.getById(categoryDto.getParentId()).getName();
        model.addAttribute(("parentName"), parentName);
        return "updateCategoryForm";
    }

    @RequestMapping(value = "/category/update", method = RequestMethod.POST)
    public String updateCategory(@RequestParam("id") long id,
                                @RequestParam("name") String name,
                                @RequestParam("description") String description,
                                @RequestParam("parent-name") String parentName) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        categoryDto.setName(name);
        categoryDto.setDesc(description);
        Category res = categoryService.getByName(parentName);
        if (res != null) {
            categoryDto.setParentId(res.getId());
        }
        Category category = categoryService.update(transformer.transformTo(categoryDto));
        return "redirect:/category/update/" + category.getId();
    }

    @RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("id") long id) {
        categoryService.delete(categoryService.getById(id));
        return "redirect:/category/admin";
    }
}
