package service.impl;

import entity.Fruit;
import repository.FruitRepository;
import service.IFruitService;

import java.util.List;

public class FruitService implements IFruitService {
    private static FruitRepository fruitRepository = new FruitRepository();

    private static FruitService fruitService = new FruitService();

    private FruitService() {}
    public static FruitService getInstance() {
        return fruitService;
    }

    @Override
    public List<Fruit> getAllProducts() {
        return fruitRepository.getAll();
    }

    @Override
    public boolean addProduct(Fruit updateProduct) {
        return fruitRepository.add(updateProduct);
    }

    @Override
    public boolean editProduct(Fruit updateProduct) {
        return fruitRepository.edit(updateProduct);
    }

    @Override
    public boolean deleteProduct(int id) {
        return fruitRepository.delete(id);
    }

    @Override
    public List<Fruit> searchProduct(String name) {
        return fruitRepository.search(name);
    }

    @Override
    public List<Fruit> sortProductAsc() {
        return fruitRepository.sortAscending();
    }

    @Override
    public List<Fruit> sortProductDes() {
        return fruitRepository.sortDescending();
    }

    @Override
    public boolean checkProduct(int id, String name) {
        return false;
    }
}
