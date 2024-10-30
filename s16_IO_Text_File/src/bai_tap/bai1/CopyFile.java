package bai_tap.bai1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tập tin nguồn: ");
        String sourceFileName = scanner.nextLine();
        System.out.println("Nhập tên tập tin đích: ");
        String targetFileName = scanner.nextLine();

        File sourceFile = new File(sourceFileName);
        File targetFile = new File(targetFileName);

        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại");
            scanner.close();
            return;
        }
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại");
            scanner.close();
            return;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {
            int Count = 0;
            int Data;

            while ((Data = fis.read()) != -1) {
                fos.write(Data);
                Count++;
            }
            System.out.println("Sao chép hoàn tất, số ký tự được sao chép: " + Count);
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
        scanner.close();
    }
}
