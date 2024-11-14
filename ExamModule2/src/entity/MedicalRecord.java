package entity;

public abstract class MedicalRecord {
    private int id;
    private String code;
    private String name;
    private String dateIn;
    private String dateOut;
    private String reason;

    public MedicalRecord() {
    }

    public MedicalRecord(int id, String code, String name, String dateIn, String dateOut, String reason) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + "STT: " + id + ", Mã bệnh án: " + code + ", Tên bệnh nhân: " + name
                + ", Ngày nhập viện: " + dateIn + ", Ngày ra viện: " + dateOut + ", Lý do ra viện: " + reason + '}';
    }
}
