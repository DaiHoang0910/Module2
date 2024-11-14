package service;

import java.util.List;

public interface IMedicalRecord<MedicalRecord> {
    List<MedicalRecord> getMedicalRecords();

    List<MedicalRecord> addRecord(MedicalRecord updateRecord);

    List<MedicalRecord> deleteRecord(String medicalRecordCode);
}
