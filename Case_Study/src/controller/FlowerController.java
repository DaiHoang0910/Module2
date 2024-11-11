package controller;

import entity.Flower;
import service.IFlowerService;
import service.IProductService;
import service.ServiceFactory;
import service.impl.FlowerService;
import utils.enum_demo.ServiceEnum;

import java.util.List;

public class FlowerController {
    private static IProductService flowerService = ServiceFactory.getInstance(ServiceEnum.FLOWER);

    public List<Flower> getAllFlower() {
        List<Flower> fruits = flowerService.getAllProducts();
        return fruits;
    }

    public boolean addFlower(Flower flower) {
        return flowerService.addProduct(flower);
    }

    public boolean editFlower(Flower flower) {
        return flowerService.editProduct(flower);
    }

    public boolean deleteFlower(int id) {
        return flowerService.deleteProduct(id);
    }

    public List<Flower> searchFlower(String name) {
        return flowerService.searchProduct(name);
    }

    public List<Flower> sortFlowerAsc() {
        return flowerService.sortProductAsc();
    }

    public List<Flower> sortFlowerDesc() {
        return flowerService.sortProductDes();
    }
}
