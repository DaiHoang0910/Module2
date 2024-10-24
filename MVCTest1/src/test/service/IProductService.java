package test.service;

import test.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayProducts();

    Product[] addProduct(int id, String name, double price);

    List<Product> editProduct(int id, String name, double price);

    void deleteProduct(int id);

    List<Product> searchProduct(String name);

    List<Product> sortProductAsc();

    List<Product> sortProductDes();

    boolean checkProduct(int id, String name);



}
