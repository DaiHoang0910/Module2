package test.controller;

import test.entity.Product;
import test.service.IProductService;
import test.service.imp.ProductService;

import java.util.List;

public class ProductController {
    private static IProductService productService = new ProductService();

    public List<Product> getAll() {
        List<Product> products = productService.getAllProducts();
        return products;
    }


    public boolean addProduct(Product updateProduct) {
        return productService.addProduct(updateProduct);
    }

    public boolean editProduct(Product updateProduct) {
        return productService.editProduct(updateProduct);
    }

    public boolean deleteProduct(int id) {
        return productService.deleteProduct(id);
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
