package ua.org.oa;

import ua.org.oa.model.Goods;
import ua.org.oa.model.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by jdev on 01.02.2016.
 */
public class Main {
    public static void main(String[] args) {
       /* Goods good1 = new Goods(1, "ProBook", 500, "nootebook", "productive and stylish nootebook");
        Goods good2 = new Goods(2, "Pavilion", 450, "nootebook", "productive nootebook");
        Goods good3 = new Goods(3, "rapoo", 30, "mouse", "input device");

        ArrayList<Goods> goodses = new ArrayList<>();
        goodses.add(good1);
        goodses.add(good2);
        goodses.add(good3);

        Shop shop = new Shop();
        shop.setGoods(goodses);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File XMLfile = new File("ShoopRecord.xml");
            jaxbMarshaller.marshal(shop, XMLfile);
            jaxbMarshaller.marshal(shop, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }*/



        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File XMLfile = new File("ShoopRecord.xml");
            Shop myShoop = (Shop) jaxbUnmarshaller.unmarshal(XMLfile);
            List<Goods> listOfGoods = myShoop.getGoods();
            for (Goods listOfGood : listOfGoods) {
                System.out.println("id = " + listOfGood.getId());
                System.out.println("Name = " + listOfGood.getName());
                System.out.println("Price = " + listOfGood.getPrice());
                System.out.println("Category = " + listOfGood.getCategory());
                System.out.println("Discription = " + listOfGood.getDiscriotion());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
