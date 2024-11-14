package repository;

import entity.MedicalRecordNormal;
import entity.MedicalRecordVip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VipRepository {
    private static List<MedicalRecordVip> vipLists = new ArrayList<>();

    public VipRepository() {
        loadMedicalRecordVip();
    }

    private void loadMedicalRecordVip() {
        try {
            File file = new File("ExamModule2/src/data/medical_records.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                if (data.length == 7) {
                    int id = Integer.parseInt(data[0]);
                    String code = data[1];
                    String name = data[2];
                    String dateIn = data[3];
                    String dateOut = data[4];
                    String reason = data[5];
                    String vipId = data[6];

                    MedicalRecordVip vipList = new MedicalRecordVip(id, code, name, dateIn, dateOut, reason, vipId);
                    vipLists.add(vipList);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    public List<MedicalRecordVip> getAll() {
        return new ArrayList<>(vipLists);
    }

    public List<MedicalRecordVip> addRecord(MedicalRecordVip updateRecord) {
        List<MedicalRecordVip> vipLists = new ArrayList<>();
        for (MedicalRecordVip record : vipLists) {
            if (record.getId() == updateRecord.getId()) {
                System.out.println("Bị trùng thông tin bệnh án");
            } else {
                vipLists.add(record);
            }
        }
        return vipLists;
    }

    public List<MedicalRecordVip> deleteRecord(String code) {
        List<MedicalRecordVip> vipList = new ArrayList<>();
        for (MedicalRecordVip record : vipList) {
            if (code.equalsIgnoreCase(record.getCode())) {
                vipList.remove(record);
            }
        }
        return vipList;
    }
}
