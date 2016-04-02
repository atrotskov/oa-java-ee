package atrotskov.controller;

import atrotskov.dto.ProductDto;
import atrotskov.model.Product;
import atrotskov.service.api.CategoryService;
import atrotskov.service.api.ProductService;
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
 * Created by alexey on 22.03.16.
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    Transformer transformer;

    @Autowired
    Util util;

    /*Пока сделаю так, чтобе не реализовывать главную страницу интернет магазина,
    как я себе представляю с банерами прочей продающей атрибутикой*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage() {
        return "redirect:/product";
    }


    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAllProducts(ModelMap mapping) {
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : productService.getAll()) {
            productDto.add(transformer.transformTo(product));
        }
        mapping.addAttribute("productList", productDto);
        return "products";
    }

    @RequestMapping(value = "/product/admin", method = RequestMethod.GET)
    public String getAllProductsAdmin(ModelMap model) {
        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product : productService.getAll()) {
            productsDto.add(transformer.transformTo(product));
        }
        model.addAttribute("productList", productsDto);
        return "productAdmin";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String addProductForm(ModelMap model) {
        List<String> listForSelect = util.getListOfCatName();
        model.addAttribute("nameList", listForSelect);
        return "addProductForm";
    }

    @RequestMapping(value = "/product/add/action", method = RequestMethod.POST)
    public String addProduct(@RequestParam("vendor") String vendorCode,
                             @RequestParam("name") String name,
                             @RequestParam("short-desc") String shortDesc,
                             @RequestParam("description") String description,
                             @RequestParam("categories") List<String> catNameList,
                             @RequestParam("price") double price,
                             @RequestParam("quantity") int quantity) {
        ProductDto productDto = new ProductDto();
        productDto.setVendorCode(vendorCode);
        productDto.setName(name);
        productDto.setShortDesc(shortDesc);
        productDto.setDesc(description);
        productDto.setPrice(price);
        productDto.setQuantity(quantity);
        Product product = transformer.transformTo(productDto);
        long id = productService.create(product).getId();
        if(!catNameList.isEmpty()) {
            for (String categorName : catNameList) {
                productService.addProductToCategory(
                        product, categoryService.getByName(categorName));
            }
        }
        return "redirect:/product/update/" + id;
    }

    @RequestMapping(value = "/product/update/{id}", method = RequestMethod.GET)
    public String updateProductForm(@PathVariable("id") long id, ModelMap model) {
        ProductDto productDto = transformer.transformTo(productService.getById(id));
        model.addAttribute("product", productDto);

        List<String> listForSelect = util.getListOfCatName();
        model.addAttribute("nameList", listForSelect);
        return "updateProductForm";
    }

    @RequestMapping(value = "/product/id/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") long id, ModelMap model) {
        ProductDto productDto = transformer.transformTo(productService.getById(id));
        model.addAttribute("product", productDto);
        return "product";
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public String updateProduct(@RequestParam("id") long id,
                                @RequestParam("vendor") String vendorCode,
                                @RequestParam("name") String name,
                                @RequestParam("short-desc") String shortDesc,
                                @RequestParam("description") String description,
                                @RequestParam("categories") List<String> catNameList,
                                @RequestParam("price") double price,
                                @RequestParam("quantity") int quantity) {
        ProductDto productDto = new ProductDto();

        productDto.setId(id);
        productDto.setVendorCode(vendorCode);
        productDto.setName(name);
        productDto.setShortDesc(shortDesc);
        productDto.setDesc(description);
        productDto.setPrice(price);
        productDto.setQuantity(quantity);
        Product product = transformer.transformTo(productDto);
        if(!catNameList.isEmpty()) {
            for (String categorName : catNameList) {
                productService.addProductToCategory(
                        product, categoryService.getByName(categorName));
            }
        }
        productService.update(product);
        return "redirect:/product/update/" + product.getId();
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") long id) {
        productService.delete(productService.getById(id));
        return "redirect:/product/admin";
    }
}
