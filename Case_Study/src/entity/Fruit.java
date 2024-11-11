package entity;

public class Fruit extends Product implements Comparable<Fruit> {
    private int quantity;
    private String origin;

    public Fruit() {

    }

    public Fruit(int id, String name, double price, int quantity, String origin) {
        super(id, name, price);
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Fruit o) {
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() == o.getId()) {
            return this.getName().compareTo(o.getName());
        }
        return -1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Số lượng: " + quantity + ", Xuất xứ: " + origin;
    }
}
