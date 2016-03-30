package atrotskov.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexey on 21.03.16.
 */
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String desc;

    @Column(name = "parent_id")
    private long parentId;

    /*@Column(name = "parent_category")
    private Category parentCat;*/

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,)
    @JoinTable(
            name = "CATEGORY_PRODUCT",
            joinColumns = @JoinColumn(name = "catgory_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )*/
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private Set<Product> productList = new HashSet<>(0);

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Product> getProductList() {
        return productList;
    }


}
