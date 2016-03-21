package atrotskov.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by alexey on 21.03.16.
 */

@Entity
@Table(name = "ORDER")
public class Order {
    @Id @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user")
    private User user;

    @OneToMany(mappedBy = "")
    private List<Product> productList;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
