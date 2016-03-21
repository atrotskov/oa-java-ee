package atrotskov.model;

import java.util.List;

/**
 * Created by alexey on 21.03.16.
 */
public class Subcategory extends Category {
    private Category parent;

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
