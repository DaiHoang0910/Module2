package entity;

public class Flower extends Product implements Comparable<Flower> {
    private String color;

    public Flower() {

    }

    public Flower(int id, String name, double price, String color) {
        super(id, name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", màu sắc: " + color;
    }

    @Override
    public int compareTo(Flower o) {
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() == o.getId()) {
            return this.getName().compareTo(o.getName());
        } else {
            return -1;
        }
    }
}
