package entity;

public class Teacher extends Person  {
    private int age;
    private String classWork;

    public Teacher() {

    }

    public Teacher(int id, String name, String address, int age, String classWork) {
        super(id, name, address);
        this.age = age;
        this.classWork = classWork;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassWork() {
        return classWork;
    }

    public void setClassWork(String classWork) {
        this.classWork = classWork;
    }

    @Override
    public String toString() {
        return super.toString() + " age= " + age + " classWork= " + classWork;
    }
}
