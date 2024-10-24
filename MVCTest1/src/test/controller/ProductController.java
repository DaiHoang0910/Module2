package test.controller;

import test.entity.Product;
import test.service.IProductService;
import test.service.imp.ProductService;

import java.util.List;

public class ProductController {
    private static IProductService productService = new ProductService();

    public List<Product> getAll() {
        return productService.displayProducts();
    }

    public Product[] addProduct(int id, String name, double price) {
        return productService.addProduct(id, name, price);
    }

    public List<Product> editProduct(int id, String newName, double newPrice) {
        return productService.editProduct(id, newName, newPrice);
    }

    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }

    public List<Product> searchProduct(String name) {
        return productService.searchProduct(name);
    }

    public List<Product> sortProductAsc() {
        return productService.sortProductAsc();
    }

    public List<Product> sortProductDes() {
        return productService.sortProductDes();
    }

}
