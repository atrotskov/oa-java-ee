package atrotskov.transformer.impl;

import atrotskov.dto.CategoryDto;
import atrotskov.dto.OrderDto;
import atrotskov.dto.ProductDto;
import atrotskov.dto.UserDto;
import atrotskov.model.Category;
import atrotskov.model.Order;
import atrotskov.model.Product;
import atrotskov.model.User;
import atrotskov.transformer.Transformer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alexey on 24.03.16.
 */
@Component
public class TransformerImpl implements Transformer {
    @Override
    public User transformTo(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());

        if (userDto.getLogin() != null) {
            user.setLogin(userDto.getLogin());
        }

        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }

        if (userDto.getFirstName() != null) {
            user.setFirstName(userDto.getFirstName());
        }

        if (userDto.getLastName() != null) {
            user.setLastName(userDto.getLastName());
        }

        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }

        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }

        if (userDto.getBirthday() != null) {
            user.setBirthday(userDto.getBirthday());
        }
        
        if (userDto.getOrders() != null) {
            Set<Order> orders = new HashSet<>();
            for (OrderDto orderDto : userDto.getOrders()) {
                orders.add(transformTo(orderDto));
            }
            user.setOrders(orders);
        }
        return user;
    }

    @Override
    public UserDto transformTo(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());

        if (user.getLogin() != null) {
            userDto.setLogin(user.getLogin());
        }

        if (user.getPassword() != null) {
            userDto.setPassword(user.getPassword());
        }

        if (user.getFirstName() != null) {
            userDto.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null) {
            userDto.setLastName(user.getLastName());
        }

        if (user.getEmail() != null) {
            userDto.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            userDto.setPassword(user.getPassword());
        }

        if (user.getBirthday() != null) {
            userDto.setBirthday(user.getBirthday());
        }

        if (user.getOrders() != null) {
            Set<OrderDto> orders = new HashSet<>();
            for (Order order : user.getOrders()) {
                orders.add(transformTo(order));
            }
            userDto.setOrders(orders);
        }

        return userDto;
    }

    @Override
    public Order transformTo(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        
        if (orderDto.getUser() != null) {
            order.setUser(transformTo(orderDto.getUser()));
        }
        if (orderDto.getProductList() != null) {
            List<Product> products = new ArrayList<>();
            for (ProductDto product : orderDto.getProductList()) {
                products.add(transformTo(product));
            }
            order.setProductList(products);
        }
        order.setTimestamp(orderDto.getTimestamp());
        return order;
    }

    @Override
    public OrderDto transformTo(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());

        if (order.getUser() != null) {
            orderDto.setUser(transformTo(order.getUser()));
        }

        if (order.getProductList() != null) {
            List<ProductDto> products = new ArrayList<>();
            for (Product product : order.getProductList()) {
                products.add(transformTo(product));
            }
            orderDto.setProductList(products);
        }
        orderDto.setTimestamp(order.getTimestamp());
        return orderDto;
    }

    @Override
    public Product transformTo(ProductDto productDto) {
        Product product = new Product();

        product.setId(productDto.getId());

        if (productDto.getName() != null) {
            product.setName(productDto.getName());
        }

        if (productDto.getDesc() != null) {
            product.setDesc(productDto.getDesc());
        }

        if (productDto.getShortDesc() != null) {
            product.setShortDesc(productDto.getShortDesc());
        }

        if (productDto.getPicture() != null) {
            product.setPicture(productDto.getPicture());
        }

        if (productDto.getVendorCode() != null) {
            product.setVendorCode(productDto.getVendorCode());
        }

        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        return product;
    }

    @Override
    public ProductDto transformTo(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());

        if (product.getName() != null) {
            productDto.setName(product.getName());
        }

        if (product.getDesc() != null) {
            productDto.setDesc(product.getDesc());
        }

        if (product.getShortDesc() != null) {
            productDto.setShortDesc(product.getShortDesc());
        }

        if (product.getPicture() != null) {
            productDto.setPicture(product.getPicture());
        }

        if (product.getVendorCode() != null) {
            productDto.setVendorCode(product.getVendorCode());
        }

        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());

        return productDto;
    }

    @Override
    public Category transformTo(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());

        if (categoryDto.getDesc() != null) {
            category.setDesc(categoryDto.getDesc());
        }

        if (categoryDto.getName() !=null ) {
            category.setName(categoryDto.getName());
        }

        category.setParentId(categoryDto.getParentId());

        if (categoryDto.getProductList() != null) {
            Set<Product> products = new HashSet<>();
            for (ProductDto product : categoryDto.getProductList()) {
                products.add(transformTo(product));
            }
            category.setProductList(products);
        }
        return category;
    }

    @Override
    public CategoryDto transformTo(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());

        if (category.getDesc() != null) {
            categoryDto.setDesc(category.getDesc());
        }

        if (category.getName() !=null ) {
            categoryDto.setName(category.getName());
        }

        categoryDto.setParentId(category.getParentId());

        if (category.getProductList() != null) {
            Set<ProductDto> products = new HashSet<>();
            for (Product product : category.getProductList()) {
                products.add(transformTo(product));
            }
            categoryDto.setProductList(products);
        }
        return categoryDto;
    }
}
