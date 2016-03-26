package atrotskov.transformer;

import atrotskov.dto.CategoryDto;
import atrotskov.dto.OrderDto;
import atrotskov.dto.ProductDto;
import atrotskov.dto.UserDto;
import atrotskov.model.Category;
import atrotskov.model.Order;
import atrotskov.model.Product;
import atrotskov.model.User;

/**
 * Created by alexey on 24.03.16.
 */
public interface Transformer {
    User transformTo(UserDto userDto);
    UserDto transformTo(User user);
    Order transformTo(OrderDto orderDto);
    OrderDto transformTo(Order order);
    Product transformTo(ProductDto productDto);
    ProductDto transformTo(Product product);
    Category transformTo(CategoryDto categoryDto);
    CategoryDto transformTo(Category category);
}
