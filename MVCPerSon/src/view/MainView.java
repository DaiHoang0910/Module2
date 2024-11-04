package view;

import controller.StudentController;
import controller.TeacherController;
import entity.Student;
import entity.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- Quản lý CodeGym --------");
        System.out.println("1. Quản lý học sinh");
        System.out.println("2. Quản lý giảng viên");
        System.out.println("3. Thoát");
        System.out.println("Mời bạn nhập lựa chọn: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                menuStudent();
                break;
            case 2:
                menuTeacher();
                break;
            case 3:
                System.out.println("Thoát");
                break;
        }
    }

    public static void menuTeacher() {
        TeacherController teacherController = new TeacherController();
        System.out.println("Menu quản lý giáo viên");
        System.out.println("1. Hiển thị danh sách giáo viên");
        System.out.println("2. Thêm mới giáo viên");
        System.out.println("3. Sửa thông tin giáo viên");
        System.out.println("4. Xóa giáo viên");
        System.out.println("5. Tìm kiếm học sinh theo tên hoặc id");
        System.out.println("Nhập lựa chọn: ");
        Scanner scanner1 = new Scanner(System.in);
        int choice1 = inputPropertyNumberInteger("lựa chọn");
        List<Teacher> teachers = new ArrayList<>();
        switch (choice1) {
            case 1:
                teachers = teacherController.getAll();
                displayTeacher(teachers);
                break;
            case 2:
                System.out.println("Thêm mới giáo viên");
                System.out.println("Nhập thứ tự giáo viên");
                int newCode = scanner1.nextInt();
                scanner1.nextLine();
                System.out.println("Nhập họ tên giáo viên");
                String newName = scanner1.nextLine();
                System.out.println("Nhập địa chỉ của giáo viên");
                String newAddress = scanner1.nextLine();
                System.out.println("Nhập tuổi của giáo viên");
                int newAge = scanner1.nextInt();
                scanner1.nextLine();
                System.out.println("Nhập lớp của giáo viên");
                String newClassWork = scanner1.nextLine();
                Teacher newTeacher = new Teacher(newCode, newName, newAddress, newAge, newClassWork);
                boolean checkAdd = teacherController.addTeacher(newTeacher);
                if (checkAdd) {
                    System.out.println("Thông tin đã được thêm");
                    System.out.println(newTeacher);
                    System.out.println("Cập nhật danh sách");
                    System.out.println("Hiển thị danh sách giáo viên");
                    teachers = teacherController.getAll();
                    displayTeacher(teachers);
                } else {
                    System.out.println("Thông tin bị trùng, vui lòng kiểm tra lại");
                }
                break;
            case 3:
                System.out.println("Sửa thông tin giáo viên");
                break;
            case 4:
                System.out.println("Xóa giáo viên");
                break;
            case 5:
                System.out.println("Tìm kiếm giáo viên theo tên");
                break;
        }
    }


    public static void menuStudent() {
        StudentController studentController = new StudentController();
        System.out.println("Menu quản lý học sinh");
        System.out.println("1. Hiển thị danh sách học sinh");
        System.out.println("2. Thêm mới học sinh");
        System.out.println("3. Sửa thông tin học sinh");
        System.out.println("4. Xóa học sinh");
        System.out.println("5. Tìm kiếm học sinh theo tên hoặc id");
        System.out.println("6. Sắp xếp học sinh theo tên hoặc id");
        System.out.println("7. Quay lại menu chính");
        System.out.println("Nhập lựa chọn: ");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        switch (choice) {
            case 1:
                students = studentController.getAll();
                displayStudent(students);
                break;
            case 2:
                System.out.println("Thêm mới học sinh");
                System.out.println("Nhập thứ tự học sinh");
                int newCode = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập họ tên học sinh");
                String newName = scanner.nextLine();
                System.out.println("Nhập địa chỉ của học sinh");
                String newAddress = scanner.nextLine();
                System.out.println("Nhập điểm của học sinh");
                double newPoint = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Nhập lớp của học sinh");
                String newClassName = scanner.nextLine();
                Student newStudent = new Student(newCode, newName, newAddress, newPoint, newClassName);
                boolean checkAdd = studentController.addStudent(newStudent);
                if (checkAdd) {
                    System.out.println("Thông tin đã được thêm");
                    System.out.println(newStudent);
                    System.out.println("Cập nhật danh sách");
                    students = studentController.getAll();
                    displayStudent(students);
                } else {
                    System.out.println("Thông tin bị trùng, vui lòng kiểm tra lại");
                }
                break;
            case 3:
                System.out.println("Sửa thông tin học sinh");
                break;
            case 4:
                System.out.println("Xóa học sinh");
                break;
            case 5:
                System.out.println("Tìm kiếm học sinh theo tên");
                String name = scanner.nextLine();
                students = studentController.searchByName(name);
                displayStudent(students);
                break;
            case 6:
                sortStudents(scanner, studentController);
                break;
            case 7:
                return;
        }
    }

    public static void displayStudent(List<Student> students) {
        System.out.printf("%-5s %-20s %-15s %-10s %-10s %n", "ID", "Name", "Address", "Points", "Class");

//        %-5s và %-20s: Định dạng chuỗi với chiều rộng cố định, - để căn trái và số để chỉ độ rộng. Ví dụ: % -5s sẽ căn trái chuỗi trong không gian 5 ký tự.
//        %-10d: Định dạng số nguyên.

        System.out.println("-------------------------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-5d %-20s %-15s %-10.2f %-10s %n",
                    student.getCode(),
                    student.getName(),
                    student.getAddress(),
                    student.getPoint(),
                    student.getClassName());
        }
    }

    public static void displayTeacher(List<Teacher> teachers) {
        System.out.printf("%-5s %-20s %-15s %-10s %-10s %n", "ID", "Name", "Address", "Age", "ClassWork");

//        %-5s và %-20s: Định dạng chuỗi với chiều rộng cố định, - để căn trái và số để chỉ độ rộng. Ví dụ: % -5s sẽ căn trái chuỗi trong không gian 5 ký tự.
//        %-10.2f: Định dạng số thập phân với chiều rộng cố định, 2 chữ số thập phân.

        System.out.println("----------------------------------------------------------------------");

        for (Teacher teacher : teachers) {
            System.out.printf("%-5d %-20s %-15s %-10d %-10s %n",
                    teacher.getCode(),
                    teacher.getName(),
                    teacher.getAddress(),
                    teacher.getAge(),
                    teacher.getClassWork());
        }
    }

    public static int inputPropertyNumberInteger(String key) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập " + key + ":");
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value < 0) {
                    System.out.print("Số phải là nguyên dương. Mời bạn nhập lại: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Bạn cần nhập định dạng số: ");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }
        return value;
    }

    public static void sortStudents(Scanner scanner, StudentController studentController) {
        List<Student> students;
        int subChoice;
        System.out.println("Bạn muốn sắp xếp theo:");
        System.out.println("1. Theo tên");
        System.out.println("2. Theo id");
        subChoice = Integer.parseInt(scanner.nextLine());
        if (subChoice == 1) {
            students = studentController.displayAllStudentSortById();
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }

        } else if (subChoice == 2) {

        } else {
            System.out.println("Invalid");
        }
    }
}
