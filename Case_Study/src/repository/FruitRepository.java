package repository;

import entity.Fruit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FruitRepository {
    private static List<Fruit> fruits = new ArrayList<>();

    static {
        fruits.add(new Fruit(1, "Cherry", 490000, 5, "America"));
        fruits.add(new Fruit(2, "Grape", 290000, 7, "Australia"));
        fruits.add(new Fruit(3, "Apple", 320000, 5, "New Zealand"));
        fruits.add(new Fruit(4, "Melon", 140000, 8, "Taiwan"));
        fruits.add(new Fruit(5, "Kiwi", 290000, 9, "New Zealand"));
        fruits.add(new Fruit(6, "Grape", 690000, 6, "Korean"));
        fruits.add(new Fruit(7, "WaterMelon", 120000, 12, "Viet Nam"));
        File file = new File("Case_Study/src/data/fruit.dat");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(fruits);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    public boolean add(Fruit updateFruit) {
        List<Fruit> fruits = getAll();
        File file = new File("Case_Study/src/data/fruit.dat");
        for (Fruit fruit : fruits) {
            if (fruit.getName().equalsIgnoreCase(updateFruit.getName()) && fruit.getOrigin().equalsIgnoreCase(updateFruit.getOrigin())) {
                return false;
            }
        }
        fruits.add(updateFruit);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(fruits);
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
        return true;
    }

    public List<Fruit> getAll() {
        List<Fruit> fruits = new ArrayList<>();
        File file = new File("Case_Study/src/data/fruit.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            fruits = (List<Fruit>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fruits;
    }

    public boolean edit(Fruit updateFruit) {
        List<Fruit> fruits = getAll();
        File file = new File("Case_Study/src/data/fruit.dat");
        boolean isUpdate = false;
        for (Fruit fruit : fruits) {
            if (fruit.getId() == updateFruit.getId()) {
                fruit.setName(updateFruit.getName());
                fruit.setPrice(updateFruit.getPrice());
                fruit.setQuantity(updateFruit.getQuantity());
                fruit.setOrigin(updateFruit.getOrigin());
                isUpdate = true;
                break;
            }
        }
        if (isUpdate) {
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(fruits);
            } catch (IOException e) {
                System.out.println("Lỗi");
                return false;
            }
        }
        return isUpdate;
    }


    public boolean delete(int id) {
        List<Fruit> fruits = getAll();
        File file = new File("Case_Study/src/data/fruit.dat");
        for (int i = fruits.size() - 1; i >= 0; i--) {
            if (fruits.get(i).getId() == id) {
                fruits.remove(i);
                try {
                    FileOutputStream outputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(fruits);
                    objectOutputStream.close();
                    outputStream.close();
                    return true;
                } catch (IOException e) {
                    System.out.println("Lỗi");
                    return false;
                }
            }
        }
        return false;
    }

    public List<Fruit> search(String name) {
        List<Fruit> fruits = getAll();
        List<Fruit> foundFruits = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().toLowerCase().contains(name.toLowerCase())) {
                foundFruits.add(fruit);
            }
        }
        return foundFruits;
    }

    public List<Fruit> sortAscending() {
        List<Fruit> sortedFruits = getAll();
        Collections.sort(sortedFruits, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return sortedFruits;
    }

    public List<Fruit> sortDescending() {
        List<Fruit> sortedFruits = getAll();
        Collections.sort(sortedFruits, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        return sortedFruits;
    }

    public boolean check(int newId, String newName) {
        List<Fruit> fruits = getAll();
        for (Fruit fruit : fruits) {
            if (fruit.getId() == newId || fruit.getName().equalsIgnoreCase(newName)) {
                return false;
            }
        }
        return true;
    }
}
