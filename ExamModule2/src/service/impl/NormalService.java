package service.impl;

import entity.MedicalRecordNormal;
import repository.NormalRepository;
import service.IMedicalRecordNormal;

import java.util.List;

public class NormalService implements IMedicalRecordNormal {
    private static NormalRepository normalRepository = new NormalRepository();

    @Override
    public List<MedicalRecordNormal> getMedicalRecords() {
        return normalRepository.getAll();
    }

    @Override
    public List<MedicalRecordNormal> addRecord(MedicalRecordNormal updateRecord) {
        return normalRepository.addRecord(updateRecord);
    }

    @Override
    public List<MedicalRecordNormal> deleteRecord(String medicalRecordCode) {
        return normalRepository.deleteRecord(medicalRecordCode);
    }
}
