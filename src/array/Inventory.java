package array;

import java.util.*;

public class Inventory {

    Map<Product, Integer> products;

    private static final Inventory inventory = new Inventory();

    private Inventory() {
        products = new HashMap<>();
    }

    public static Inventory getInstance() {
        return inventory;
    }

    public void addItems(Map<Product, Integer> items) {
        items.forEach(
                (k, v) -> {
                    Integer quantity = products.get(k);
                    if (!Objects.isNull(quantity) && quantity > 0) {
                        products.put(k, quantity + v);
                    } else {
                        products.put(k, v);
                    }
                }
        );
    }

    public void removeItems(Map<Product, Integer> items) {
        items.forEach(
                (k, v) -> {
                    Integer quantity = products.get(k);
                    if (!Objects.isNull(quantity) && quantity > 0 && v >= quantity) {
                        products.remove(k);
                    } else if (v < quantity) {
                        products.put(k, quantity - v);
                    }
                }
        );
    }

    public Integer getAvailableAmount(Product product) {
        if (!Objects.isNull(products.get(product))) {
            return products.get(product);
        }
        return 0;
    }


}
