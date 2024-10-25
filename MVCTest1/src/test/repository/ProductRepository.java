package test.repository;

import test.entity.Product;

import java.util.*;

public class ProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Pineapple", 10));
        products.add(new Product(2, "Banana", 8));
        products.add(new Product(3, "Apple", 6));
        products.add(new Product(4, "Orange", 6));
        products.add(new Product(5, "Mango", 7));
    }

    public boolean add(Product product) {
        return products.add(product);
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public boolean edit(Product updatedProduct) {
        for (Product product : products) {
            if (product.getId() == updatedProduct.getId()) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return true;
            }
        }
        return false;
    }


    public boolean delete(int id) {
        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Product> search(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> sortAscending() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return sortedProducts;
    }

    public List<Product> sortDescending() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        return sortedProducts;
    }

    public boolean check(int newId, String newName) {
        for (Product product : products) {
            if (product.getId() == newId || product.getName().equalsIgnoreCase(newName)) {
                return false;
            }
        }
        return true;
    }

}
