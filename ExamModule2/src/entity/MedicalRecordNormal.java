package entity;

public class MedicalRecordNormal extends MedicalRecord {
    private double price;

    public MedicalRecordNormal() {

    }

    public MedicalRecordNormal(int id, String code, String name, String dateIn, String dateOut, String reason, double price) {
        super(id, code, name, dateIn, dateOut, reason);
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + "giá(VND)= " + price;
    }
}
