package ua.org.oa;

import ua.org.oa.model.Goods;
import ua.org.oa.model.Shop;
import ua.org.oa.util.Entity;
import ua.org.oa.util.jaxbUtil;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;

/**
 * Created by jdev on 01.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        final String jaxbXMLFile = "jaxbXMLShoop.xml";
        Goods good1 = new Goods(1, "ProBook", 500, "nootebook", "productive and stylish nootebook");
        Goods good2 = new Goods(2, "Pavilion", 450, "nootebook", "productive nootebook");
        Goods good3 = new Goods(3, "rapoo", 30, "mouse", "input device");

        ArrayList<Goods> goodses = new ArrayList<>();
        goodses.add(good1);
        goodses.add(good2);
        goodses.add(good3);

        Entity.getShopInstance(goodses);

        try {
            jaxbUtil.doMurshaller(Entity.getShopInstance(goodses), jaxbXMLFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            Shop myShop = jaxbUtil.DoUnmarshaller(jaxbXMLFile);
            System.out.println(myShop.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
