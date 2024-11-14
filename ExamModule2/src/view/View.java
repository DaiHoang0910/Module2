package view;

import controller.NormalController;
import controller.VipController;
import entity.MedicalRecord;
import entity.MedicalRecordNormal;
import entity.MedicalRecordVip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách các bệnh án");
        System.out.println("4. Thoát");
        System.out.println("Nhap lua chon");
        int choice = scanner.nextInt();
        List<MedicalRecordVip> medicalRecordVipList = new ArrayList<>();
        List<MedicalRecordNormal> medicalRecordNormalsList = new ArrayList<>();
        NormalController normalController = new NormalController();
        VipController vipController = new VipController();
        switch (choice) {
            case 1:
                System.out.println("1. Thêm mới");
                scanner.nextLine();
                System.out.println("Loại bệnh án thêm mới (benh an thuong / benh an Vip ");
                String benhAn = scanner.nextLine();
                if (benhAn.equalsIgnoreCase("benh an thuong")) {
                    System.out.println("Nhập STT bệnh án");
                    int newId = scanner.nextInt();
                    System.out.println("Nhập mã bệnh án");
                    String newCode = scanner.nextLine();
                    while (!isValidName(newCode)) {
                        System.out.println("Vui long nhap lai");
                        System.out.println("Nhập mã bệnh án");
                        newCode = scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("Nhập tên bệnh nhân");
                    String newName = scanner.nextLine();
                    System.out.println("Nhập ngày vào viện");
                    String newDateIn = scanner.nextLine();
                    System.out.println("Nhập ngày ra viện");
                    String newDateOut = scanner.nextLine();
                    System.out.println("Nhập lý do vào việc");
                    String newReason = scanner.nextLine();
                    System.out.println("Nhập tiền viện phí");
                    double newPrice = scanner.nextDouble();
                    MedicalRecordNormal recordNormal = new MedicalRecordNormal(newId, newCode, newName, newDateIn, newDateOut, newReason, newPrice);
                    medicalRecordNormalsList.add(recordNormal);
                    for (MedicalRecordNormal medicalRecordNormal : medicalRecordNormalsList) {
                        System.out.println(medicalRecordNormal);
                    }

                } else if (benhAn.equalsIgnoreCase("benh an vip")) {
                    System.out.println("Nhập STT bệnh án");
                    int newId = scanner.nextInt();
                    System.out.println("Nhập mã bệnh án");
                    String newCode = scanner.nextLine();
                    while (!isValidName(newCode)) {
                        System.out.println("Vui long nhap lai");
                        System.out.println("Nhập mã bệnh án");
                        newCode = scanner.nextLine();
                    }
                    scanner.close();
                    System.out.println("Nhập tên bệnh nhân");
                    String newName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Nhập ngày vào viện");
                    String newDateIn = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Nhập ngày ra viện");
                    String newDateOut = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Nhập lý do vào việc");
                    String newReason = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Nhập loai Vip(VIP I/ VIP II/ VIP III)");
                    String newVip = scanner.nextLine();
                    MedicalRecordVip recordVip = new MedicalRecordVip(newId, newCode, newName, newDateIn, newDateOut, newReason, newVip);
                    medicalRecordVipList.add(recordVip);
                    for (MedicalRecordVip medicalRecordVip : medicalRecordVipList) {
                        System.out.println(medicalRecordVip);
                    }
                } else {
                    System.out.println("Nhap khong hop le");
                }
                break;
            case 2:
                System.out.println("2. Xóa");
                scanner.nextLine();
                System.out.print("Nhập mã bệnh án để xóa: ");
                String code = scanner.nextLine();
                normalController.delete(code);
                vipController.deleteVip(code);
                System.out.println("Hiển thị danh sách các bệnh án");
                medicalRecordNormalsList = normalController.getAll();
                for (MedicalRecordNormal medicalRecordNormal : medicalRecordNormalsList) {
                    System.out.println(medicalRecordNormal);
                }
                medicalRecordVipList = vipController.getAll();
                for (MedicalRecordVip medicalRecordVip : medicalRecordVipList) {
                    System.out.println(medicalRecordVip);
                }
                break;
            case 3:
                System.out.println("3. Xem danh sách các bệnh án");
                medicalRecordNormalsList = normalController.getAll();
                for (MedicalRecordNormal medicalRecordNormal : medicalRecordNormalsList) {
                    System.out.println(medicalRecordNormal);
                }
                medicalRecordVipList = vipController.getAll();
                for (MedicalRecordVip medicalRecordVip : medicalRecordVipList) {
                    System.out.println(medicalRecordVip);
                }
                break;
            case 4:
                System.out.println("4. Thoát");
                scanner.close();
                return;
            default:
                System.out.println("Chọn chức năng không hợp lệ. ");
                break;
        }

    }

    public static boolean isValidName(String code) {
        String regex = "^BA-\\d{3}$";
        return !code.matches(regex);
    }


//    ^BA-\d{3}$

}
