package controller;

import entity.MedicalRecord;
import entity.MedicalRecordNormal;
import service.IMedicalRecord;
import service.impl.NormalService;

import java.util.ArrayList;
import java.util.List;

public class NormalController {
    private static IMedicalRecord normalService = new NormalService();

    public List<MedicalRecordNormal> getAll() {
        List<MedicalRecordNormal> normalList = normalService.getMedicalRecords();
        return normalList;
    }

    public List<MedicalRecordNormal> add(MedicalRecordNormal normal) {
        List<MedicalRecordNormal> normalList = normalService.getMedicalRecords();
        normalList.add(normal);
        return normalList;
    }
    public List<MedicalRecordNormal> delete(MedicalRecordNormal normal) {
        List<MedicalRecordNormal> normalList = normalService.getMedicalRecords();
        normalList.remove(normal);
        return normalList;
    }
}
