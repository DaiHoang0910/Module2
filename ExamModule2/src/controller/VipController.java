package controller;

import entity.MedicalRecord;
import entity.MedicalRecordVip;
import service.IMedicalRecord;
import service.impl.VipService;

import java.util.List;

public class VipController {
    private static IMedicalRecord vipService = new VipService();

    public List<MedicalRecordVip> getAll() {
        List<MedicalRecordVip> vipList = vipService.getMedicalRecords();
        return vipList;
    }

    public List<MedicalRecordVip> addVip(MedicalRecordVip vip) {
        List<MedicalRecordVip> vipList = vipService.getMedicalRecords();
        vipList.add(vip);
        return vipList;
    }

    public List<MedicalRecordVip> deleteVip(String code) {
        List<MedicalRecordVip> vipList = vipService.deleteRecord(code);
        return vipList;
    }
}
