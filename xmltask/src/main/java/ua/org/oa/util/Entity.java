package ua.org.oa.util;

import ua.org.oa.model.Goods;
import ua.org.oa.model.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdev on 07.02.2016.
 */
public class Entity {
    public static Shop getShopInstance(ArrayList<Goods> arrGoods){
        Shop shop = new Shop();
        shop.setGoods(arrGoods);
        return shop;
    }
}
