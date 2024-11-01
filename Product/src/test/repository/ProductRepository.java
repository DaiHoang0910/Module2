package test.repository;

import test.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Pineapple", 10));
        products.add(new Product(2, "Banana", 8));
        products.add(new Product(3, "Apple", 6));
        products.add(new Product(4, "Orange", 6));
        products.add(new Product(5, "Mango", 7));
        File file = new File("Product/src/test/data/product.dat");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    public boolean add(Product updateProduct) {
        File file = new File("Product/src/test/data/product.dat");
        List<Product> products = getAll();
        for (Product product : products) {
            if (product.getId() == updateProduct.getId() || product.getName().equals(updateProduct.getName()) || product.getPrice() == updateProduct.getPrice()) {
                return false;
            }
        }
        products.add(updateProduct);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
        return true;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        File file = new File("Product/src/test/data/product.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public boolean edit(Product updatedProduct) {
        File file = new File("Product/src/test/data/product.dat");
        List<Product> products = getAll();
        for (Product product : products) {
            if (product.getId() == updatedProduct.getId()) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                try {
                    FileOutputStream outputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(products);
                    return true;
                } catch (IOException e) {
                    System.out.println("Lỗi");
                    return false;
                }
            }
        }
        return false;

    }


    public boolean delete(int id) {
        File file = new File("Product/src/test/data/product.dat");
        List<Product> products = getAll();
        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                try {
                    FileOutputStream outputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(products);
                    return true;
                } catch (IOException e) {
                    System.out.println("Lỗi");
                    return false;
                }
            }
        }
        return false;
    }

    public List<Product> search(String name) {
        List<Product> products = getAll();
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> sortAscending() {
        List<Product> sortedProducts = getAll();
        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return sortedProducts;
    }

    public List<Product> sortDescending() {
        List<Product> sortedProducts = getAll();
        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        return sortedProducts;
    }

    public boolean check(int newId, String newName) {
        List<Product> products = getAll();
        for (Product product : products) {
            if (product.getId() == newId || product.getName().equalsIgnoreCase(newName)) {
                return false;
            }
        }
        return true;
    }

}
