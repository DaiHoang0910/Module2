package repository;

import entity.MedicalRecordNormal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NormalRepository {
    private static List<MedicalRecordNormal> normalLists = new ArrayList<>();

    public NormalRepository() {
        loadMedicalRecordNormal();
    }

    private void loadMedicalRecordNormal() {
        try {
            File file = new File("ExamModule2/src/data/medical_records1.csv");
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
                    double price = Double.parseDouble(data[6]);

                    MedicalRecordNormal record = new MedicalRecordNormal(id, code, name, dateIn, dateOut, reason, price);
                    normalLists.add(record);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        } catch (IOException e) {
            System.out.println("Lỗi");
        } catch (NumberFormatException e) {
            System.out.println("Ngoại lệ định dạng số.");
        }
    }

    public List<MedicalRecordNormal> getAll() {
        return new ArrayList<>(normalLists);
    }

    public List<MedicalRecordNormal> addRecord(MedicalRecordNormal updateRecord) {
        List<MedicalRecordNormal> normalList = new ArrayList<>();
        for (MedicalRecordNormal record : normalList) {
            if (record.getId() == updateRecord.getId()) {
                System.out.println("Bị trùng thông tin bệnh án");
            } else {
                normalList.add(record);
            }
        }
        return normalList;
    }

    public List<MedicalRecordNormal> deleteRecord(String code) {
        List<MedicalRecordNormal> normalList = new ArrayList<>();
        for (MedicalRecordNormal record : normalList) {
            if (code.equalsIgnoreCase(record.getCode())) {
                normalList.remove(record);
            }
        }
        return normalList;
    }


}
