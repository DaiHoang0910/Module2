package test.service.imp;

import test.entity.Product;
import test.repository.ProductRepository;
import test.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private static ProductRepository productRepository = new ProductRepository();


    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    @Override
    public boolean addProduct(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean editProduct(Product updateProduct) {
        return productRepository.edit(updateProduct);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.delete(id);
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
