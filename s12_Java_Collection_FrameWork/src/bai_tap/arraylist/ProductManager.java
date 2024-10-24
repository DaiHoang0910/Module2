package bai_tap.arraylist;

import bai_tap.arraylist.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng");
            return;
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public boolean deleteProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}
