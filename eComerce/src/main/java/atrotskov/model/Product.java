package atrotskov.model;

import javax.persistence.*;

/**
 * Created by alexey on 21.03.16.
 */

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "desc")
    private String desc;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}