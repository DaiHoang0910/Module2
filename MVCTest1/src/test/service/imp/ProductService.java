package test.service.imp;

import test.entity.Product;
import test.repository.ProductRepository;
import test.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private static ProductRepository productRepository = new ProductRepository();


    @Override
    public List<Product> displayProducts() {
        return productRepository.getAll();
    }

    @Override
    public Product[] addProduct(int id, String name, double price) {
        if (productRepository.check(id, name)) {
            Product product = new Product(id, name, price);
            productRepository.add(product);
            return new Product[]{product};
        } else {
            System.out.println("Sản phẩm đã tồn tại với ID hoặc tên này.");
            return null;
        }
    }

    @Override
    public List<Product> editProduct(int id, String newName, double newPrice) {
        return productRepository.edit(id, newName, newPrice);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> searchProduct(String name) {
        return productRepository.search(name);
    }

    @Override
    public List<Product> sortProductAsc() {
        return productRepository.sortAscending();
    }

    @Override
    public List<Product> sortProductDes() {
        return productRepository.sortDescending();
    }

    @Override
    public boolean checkProduct(int id, String name) {
        return false;
    }


}
