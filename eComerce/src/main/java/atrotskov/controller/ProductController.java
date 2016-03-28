package atrotskov.controller;

import atrotskov.dto.ProductDto;
import atrotskov.model.Product;
import atrotskov.service.api.ProductService;
import atrotskov.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    Transformer transformer;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAllUsers(ModelMap mapping) {
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : productService.getAll()) {
            productDto.add(transformer.transformTo(product));
        }
        mapping.addAttribute("productList", productDto);
        return "products";
    }

    @RequestMapping(value = "/product/admin", method = RequestMethod.GET)
    public String getAllUsersAdmin(ModelMap mapping) {
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : productService.getAll()) {
            productDto.add(transformer.transformTo(product));
        }
        mapping.addAttribute("productList", productDto);
        return "productAdmin";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String addProductForm() {
        return "addProductForm";
    }

    @RequestMapping(value = "/product/add/action", method = RequestMethod.POST)
    public String addProduct(@RequestParam("vendor") String vendorCode,
                             @RequestParam("name") String name,
                             @RequestParam("short-desc") String shortDesc,
                             @RequestParam("description") String description,
                             @RequestParam("price") double price,
                             @RequestParam("quantity") int quantity) {
        ProductDto productDto = new ProductDto();
        productDto.setVendorCode(vendorCode);
        productDto.setName(name);
        productDto.setShortDesc(shortDesc);
        productDto.setDesc(description);
        productDto.setPrice(price);
        productDto.setQuantity(quantity);
        long id = productService.create(transformer.transformTo(productDto)).getId();
        return "redirect:/product/update/" + id;
    }

    @RequestMapping(value = "/product/update/{id}", method = RequestMethod.GET)
    public String updateProductForm(@PathVariable("id") long id, ModelMap model) {
        ProductDto productDto = transformer.transformTo(productService.getById(id));
        model.addAttribute("product", productDto);
        return "updateProductForm";
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    public String updateProduct(@RequestParam("id") long id,
                                @RequestParam("vendor") String vendorCode,
                                @RequestParam("name") String name,
                                @RequestParam("short-desc") String shortDesc,
                                @RequestParam("description") String description,
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
        Product product = productService.update(transformer.transformTo(productDto));
        return "redirect:/product/update/" + product.getId();
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") long id) {
        productService.getById(id);
        productService.delete(productService.getById(id));
        return "redirect:/product/admin";
    }
}
