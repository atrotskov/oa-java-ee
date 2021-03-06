package atrotskov.controller;

import atrotskov.dto.ProductDto;
import atrotskov.modules.cart.api.Cart;
import atrotskov.service.api.ProductService;
import atrotskov.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jdev on 02.04.2016.
 */
@Controller
@Scope("request")
public class CartController {

    @Autowired
    Cart cart;

    @Autowired
    Transformer transformer;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(ModelMap model) {
        model.addAttribute("totalPrice", cart.getTotalPrice());
        return "cart";
    }

    @RequestMapping(value = "/cart/tocart", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<ProductDto> addToCart(@RequestParam("id") long id) {
        cart.add(transformer.transformTo(productService.getById(id)));
        return cart.getAll();
    }

    @RequestMapping(value = "/cart/fromcart", method = RequestMethod.POST)
    public String deleteFromCart(@RequestParam("id") long id) {
        cart.delete(transformer.transformTo(productService.getById(id)));
        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String checkoutCart() {

        /*В данном месте будет следующая логика:
        Беру текущего пользователя из сессии спринг секьюра и объект
                корзины из сессии и все это передаю в качестве двух параметров
                методу создания нового Ордера*/

        String msg = "Спасибо за Ваш заказ. В скором времени с вами свяжется менеджер";
        return msg;
    }
}