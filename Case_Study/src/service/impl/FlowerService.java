package service.impl;

import entity.Flower;
import repository.FlowerRepository;
import service.IFlowerService;

import java.util.List;

public class FlowerService implements IFlowerService {
    private static FlowerRepository flowerRepository = new FlowerRepository();

    @Override
    public List<Flower> getAllProducts() {
        return flowerRepository.getAll();
    }

    @Override
    public boolean addProduct(Flower updateProduct) {
        return flowerRepository.add(updateProduct);
    }

    @Override
    public boolean editProduct(Flower updateProduct) {
        return flowerRepository.edit(updateProduct);
    }

    @Override
    public boolean deleteProduct(int id) {
        return flowerRepository.delete(id);
    }

    @Override
    public List<Flower> searchProduct(String name) {
        return flowerRepository.search(name);
    }

    @Override
    public List<Flower> sortProductAsc() {
        return flowerRepository.sortAscending();
    }

    @Override
    public List<Flower> sortProductDes() {
        return flowerRepository.sortDescending();
    }

    @Override
    public boolean checkProduct(int id, String name) {
        return false;
    }
}
