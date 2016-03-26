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

    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ProductDto> getAllUsers() {
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : productService.getAll()) {
            productDto.add(transformer.transformTo(product));
        }
        return productDto;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String addProductForm() {
        return "addProductForm";
    }

    @RequestMapping(value = "/product/add/action", method = RequestMethod.GET)
    public String addProduct(ModelMap mapping,
                             @RequestParam("vendor") String vendorCode,
                             @RequestParam("name") String name,
                             @RequestParam("short-desc") String shortDesc,
                             @RequestParam("description") String description,
                             @RequestParam("price") double price,
                             @RequestParam("quantity") int quanti) {
        ProductDto productDto = new ProductDto();
        productDto.setVendorCode(vendorCode);
        productDto.setName(name);
        productDto.setShortDesc(shortDesc);
        productDto.setDesc(description);
        productDto.setPrice(price);
        productDto.setQuantity(quanti);

        productDto = transformer.
                transformTo(productService.create(
                        transformer.transformTo(productDto)));
        mapping.addAttribute("product", productDto);
        return "redirect: product";
    }

    @RequestMapping(value = "/product/update/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("id") long id, ModelMap model) {
        ProductDto productDto = transformer.transformTo(productService.getById(id));
        model.addAttribute("product", productDto);
        return "productUpdate";
    }

    @RequestMapping(value = "/product/delete")
    public void deleteProduct(ProductDto productDto) {

    }

}
