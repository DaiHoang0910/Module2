package service;

import entity.Product;

import java.util.List;

public interface IProductService<Product> {
    List<Product> getAllProducts();

    boolean addProduct(Product updateProduct);

    boolean editProduct(Product updateProduct);

    boolean deleteProduct(int id);

    List<Product> searchProduct(String name);

    List<Product> sortProductAsc();

    List<Product> sortProductDes();

    boolean checkProduct(int id, String name);
}
