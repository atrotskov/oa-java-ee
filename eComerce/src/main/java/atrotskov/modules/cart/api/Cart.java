package atrotskov.modules.cart.api;

import atrotskov.dto.ProductDto;

import java.util.List;

/**
 * Created by jdev on 02.04.2016.
 */
public interface Cart {
    void add(ProductDto productDto);
    void delete(ProductDto productDto);
    List<ProductDto> getAll();
    public double getTotalPrice();
}

