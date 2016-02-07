package ua.org.oa.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.PrimitiveIterator;

/**
 * Created by jdev on 01.02.2016.
 */
public class Goods {

    private long id;

    private String name;
    private float price;
    private String category;
    private String discriotion;

    public Goods(){

    };

    public Goods(long id, String name, float price, String category, String discriotion) {
        setId(id);
        setName(name);
        setPrice(price);
        setCategory(category);
        setDiscriotion(discriotion);
    }

    public long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    @XmlElement
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDiscriotion() {
        return discriotion;
    }

    @XmlElement
    public void setDiscriotion(String discriotion) {
        this.discriotion = discriotion;
    }
}
