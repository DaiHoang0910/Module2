package thuc_hanh.bai1_optional.animal;

import thuc_hanh.bai1_optional.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck - cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
