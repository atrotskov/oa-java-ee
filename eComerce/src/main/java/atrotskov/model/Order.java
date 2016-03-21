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
}
