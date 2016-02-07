package ua.org.oa.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by jdev on 01.02.2016.
 */
@XmlRootElement
public class Shop {
    ArrayList<Goods> goods;

    public ArrayList<Goods> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        String result = "";
        for (Goods good : this.goods) {
            result += "--------------------------" + "\n" +
                    "id = " + good.getId() + "\n" +
                    "Name = " + good.getName() + "\n" +
                    "Price = " + good.getPrice() + "\n" +
                    "Category = " + good.getCategory() + "\n" +
                    "Discription = " + good.getDiscriotion() + "\n";
        }
        return result;
    }
}
