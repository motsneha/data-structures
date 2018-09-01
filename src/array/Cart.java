package array;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {

    private Map<Product, Integer> products;
    private double price;

    public Cart() {
        products = new HashMap<>();
        price = 0;
    }

    public void addItem(Product product, Integer amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Amount should be greater than zero");
        }
        Integer initialQuantity = products.getOrDefault(product, 0);
        products.put(product, amount + initialQuantity);
        price = price + product.getPrice() * (amount + initialQuantity);
    }

    public void removeItem(Product product) throws Exception {
        if (!Objects.isNull(products.get(product))) {
            price = price - (product.getPrice() * products.get(product));
            products.remove(product);
        } else {
            throw new Exception("Product not in cart");
        }
    }

    public void generateInvoice() {

        products.forEach((k, v) -> {
            System.out.println(k.getName() + " " + v + " " + v * k.getPrice());
        });
        System.out.println("Total price: " + price);
    }

    public void checkOut() {
        Inventory.getInstance().removeItems(products);
        products = new HashMap<>();
        price = 0;
    }

    public void emptyCart() {
        products = new HashMap<>();
        price = 0;
    }

}
