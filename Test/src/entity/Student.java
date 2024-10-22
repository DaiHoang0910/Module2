package entity;

public class Student extends Person {
    private double point;
    private String className;

    public Student() {

    }

    @Override
    public void work() {
        System.out.println("Đi học");
    }

    public Student(int id, String name, String address, double point, String className) {
        super(id, name, address);
        this.point = point;
        this.className = className;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
