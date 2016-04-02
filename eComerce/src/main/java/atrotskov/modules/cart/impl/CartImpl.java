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

    @Override
    public void add(ProductDto productDto) {
        productsDto.add(productDto);
    }

    @Override
    public void delete(ProductDto productDto) {
        for (int i = 0; i < productsDto.size(); i++) {
            if (productsDto.get(i).getId() == productDto.getId()) {
                productsDto.remove(i);
                System.out.println("product was deleted");
            }
            return;
        }
        //productsDto.remove(productDto); не работает, наверное объекты не эквивалентны,
        // нужно будет проверить.
    }

    @Override
    public List<ProductDto> getAll() {
       return productsDto;
    }

    @Override
    public double getTotalPrice() {
        double sum = 0;
        for (ProductDto productDto : productsDto) {
            sum += productDto.getPrice();
        }
        return sum;
    }
}
