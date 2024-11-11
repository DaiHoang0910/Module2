package service;

import service.impl.FlowerService;
import service.impl.FruitService;
import utils.enum_demo.ServiceEnum;

public class ServiceFactory {
    private ServiceFactory() {
    }

    public static IProductService getInstance(ServiceEnum serviceEnum) {
        switch (serviceEnum) {
            case FRUIT:
                return FruitService.getInstance();
            case FLOWER:
                return FlowerService.getInstance();
        }
        return null;
    }

}
