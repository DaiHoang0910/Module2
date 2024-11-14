package service.impl;

import entity.MedicalRecordVip;
import repository.VipRepository;
import service.IMedicalRecordVip;

import java.util.List;

public class VipService implements IMedicalRecordVip {
    private static VipRepository vipRepository = new VipRepository();

    @Override
    public List<MedicalRecordVip> getMedicalRecords() {
        return vipRepository.getAll();
    }

    @Override
    public List<MedicalRecordVip> addRecord(MedicalRecordVip updateRecord) {
        return vipRepository.addRecord(updateRecord);
    }

    @Override
    public List<MedicalRecordVip> deleteRecord(String medicalRecordCode) {
        return vipRepository.deleteRecord(medicalRecordCode);
    }
}
