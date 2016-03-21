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
}