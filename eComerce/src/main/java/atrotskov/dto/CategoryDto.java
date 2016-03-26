package atrotskov.dto;



import java.util.Set;

/**
 * Created by alexey on 24.03.16.
 */
public class CategoryDto {
    private long id;

    private String name;

    private String desc;

    private long parentId;

    private Set<ProductDto> productList;

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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Set<ProductDto> getProductList() {
        return productList;
    }

    public void setProductList(Set<ProductDto> productList) {
        this.productList = productList;
    }
}
