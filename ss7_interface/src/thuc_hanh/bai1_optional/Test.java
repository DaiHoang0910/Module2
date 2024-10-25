package thuc_hanh.bai1_optional;

import thuc_hanh.bai1_optional.animal.Animal;
import thuc_hanh.bai1_optional.animal.Chicken;
import thuc_hanh.bai1_optional.animal.Tiger;
import thuc_hanh.bai1_optional.edible.Edible;
import thuc_hanh.bai1_optional.fruit.Fruit;
import thuc_hanh.bai1_optional.fruit.Apple;
import thuc_hanh.bai1_optional.fruit.Orange;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
