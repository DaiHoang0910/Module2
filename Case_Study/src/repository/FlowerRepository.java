package repository;

import entity.Flower;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlowerRepository {
    private static List<Flower> flowerList = new ArrayList<>();

    static {
        flowerList.add(new Flower(1, "Rose", 10000, "Red"));
        flowerList.add(new Flower(2, "Tulip", 12000, "Purple"));
        flowerList.add(new Flower(3, "Daisy ", 80000, "White"));
        flowerList.add(new Flower(4, "Daisy", 50000, "Yellow"));
        flowerList.add(new Flower(5, "Orchid", 23000, "Purple"));
        flowerList.add(new Flower(6, "Sunflower ", 31000, "Yellow"));
        File file = new File("Case_Study/src/data/flower.dat");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(flowerList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    public boolean add(Flower updateFlower) {
        List<Flower> flowers = getAll();
        File file = new File("Case_Study/src/data/flower.dat");
        for (Flower flower : flowers) {
            if (flower.getName().equalsIgnoreCase(updateFlower.getName()) && flower.getColor().equalsIgnoreCase(updateFlower.getColor())) {
                return false;
            }
        }
        flowers.add(updateFlower);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(flowers);
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
        return true;
    }

    public List<Flower> getAll() {
        List<Flower> flowers = new ArrayList<>();
        File file = new File("Case_Study/src/data/flower.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            flowers = (List<Flower>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flowers;
    }

    public boolean edit(Flower updateFlower) {
        List<Flower> flowers = getAll();
        File file = new File("Case_Study/src/data/flower.dat");
        boolean isUpdated = false;
        for (Flower flower : flowers) {
            if (flower.getId() == updateFlower.getId()) {
                flower.setName(updateFlower.getName());
                flower.setPrice(updateFlower.getPrice());
                flower.setColor(updateFlower.getColor());
                isUpdated = true;
                break;
            }
        }
        if (isUpdated) {
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(flowers);
            } catch (IOException e) {
                System.out.println("Lỗi");
                return false;
            }
        }
        return isUpdated;
    }


    public boolean delete(int id) {
        List<Flower> flowers = getAll();
        File file = new File("Case_Study/src/data/flower.dat");
        for (int i = flowers.size() - 1; i >= 0; i--) {
            if (flowers.get(i).getId() == id) {
                flowers.remove(i);
                try {
                    FileOutputStream outputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(flowers);
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

    public List<Flower> search(String name) {
        List<Flower> flowers = getAll();
        List<Flower> foundFlowers = new ArrayList<>();
        for (Flower flower : flowers) {
            if (name.equalsIgnoreCase(flower.getName())) {
                foundFlowers.add(flower);
            }
        }
        return foundFlowers;
    }

    public List<Flower> sortAscending() {
        List<Flower> sortedFlowers = getAll();
        Collections.sort(sortedFlowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return sortedFlowers;
    }

    public List<Flower> sortDescending() {
        List<Flower> sortedFlowers = getAll();
        Collections.sort(sortedFlowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        return sortedFlowers;
    }

    public boolean check(int newId, String newName) {
        List<Flower> flowers = getAll();
        for (Flower flower : flowers) {
            if (flower.getId() == newId || flower.getName().equalsIgnoreCase(newName)) {
                return false;
            }
        }
        return true;
    }
}
