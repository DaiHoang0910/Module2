package repository;

import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
//        students.add(new Student(1, "Nguyễn Văn A", "Hà Nội", 10, "C0824G1"));
//        students.add(new Student(2, "Nguyễn Văn B", "Hà Nội", 10, "C0824G1"));
//        students.add(new Student(3, "Nguyễn Văn C", "Hà Nội", 10, "C0824G1"));
//        students.add(new Student(4, "Nguyễn Văn D", "Hà Nội", 10, "C0824G1"));
//        students.add(new Student(5, "Nguyễn Văn F", "Hà Nội", 10, "C0824G1"));

        loadStudentsFromCSV();
    }

    private static void loadStudentsFromCSV() {
        try {
            File file = new File("Test/src/data/students.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String address = data[2];
                    double points = Double.parseDouble(data[3]);
                    String className = data[4];

                    Student student = new Student(id, name, address, points, className);
                    students.add(student);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    public List<Student> getAll() {
        return students;
    }

    public boolean addStudent(Student UpdateStudent) {
        for (Student student : students) {
            if (student.getCode() == UpdateStudent.getCode()) {
                return false;
            }
        }
        students.add(UpdateStudent);
        return true;
    }
}
