package entity;

public class MedicalRecordVip extends MedicalRecord {
    private String vipId;

    public MedicalRecordVip() {

    }

    public MedicalRecordVip(int id, String code, String name, String dateIn, String dateOut, String reason, String vipId) {
        super(id, code, name, dateIn, dateOut, reason);
        this.vipId = vipId;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId;
    }

    @Override
    public String toString() {
        return super.toString() + ", VipId: " + vipId;
    }
}
