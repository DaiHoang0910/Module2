package controller;

import entity.Fruit;
import service.IFruitService;
import service.IProductService;
import service.ServiceFactory;
import service.impl.FruitService;
import utils.enum_demo.ServiceEnum;

import java.util.List;

public class FruitController {
    private static IProductService fruitService = ServiceFactory.getInstance(ServiceEnum.FRUIT);

    public List<Fruit> getAllFruit() {
        List<Fruit> fruits = fruitService.getAllProducts();
        return fruits;
    }

    public boolean addFruit(Fruit fruit) {
        return fruitService.addProduct(fruit);
    }

    public boolean editFruit(Fruit fruit) {
        return fruitService.editProduct(fruit);
    }

    public boolean deleteFruit(int id) {
        return fruitService.deleteProduct(id);
    }

    public List<Fruit> searchFruit(String name) {
        return fruitService.searchProduct(name);
    }

    public List<Fruit> sortFruitAsc() {
        return fruitService.sortProductAsc();
    }

    public List<Fruit> sortFruitDesc() {
        return fruitService.sortProductDes();
    }
}
