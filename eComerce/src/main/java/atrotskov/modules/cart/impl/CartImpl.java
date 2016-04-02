package atrotskov.modules.cart.impl;

import atrotskov.dto.ProductDto;
import atrotskov.modules.cart.api.Cart;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by jdev on 02.04.2016.
 */
@Component
@Scope(value = "session"/*, proxyMode = ScopedProxyMode.INTERFACES*/)
public class CartImpl implements Serializable, Cart {
    private List<ProductDto> productsDto = new ArrayList<>();

    public void add(ProductDto productDto) {
        productsDto.add(productDto);
    }

    public List<ProductDto> getAll() {
       return productsDto;
    }

}
