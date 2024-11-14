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
        File file = new File("Test/src/data/data.dat");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    private static <Students> void loadStudentsFromCSV() {
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

                    Students student = (Students) new Student(id, name, address, points, className);
                    students.add((Student) student);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        File file = new File("Test/src/data/data.dat");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public boolean addStudent(Student UpdateStudent) {
        List<Student> students = getAll();
        File file = new File("Test/src/data/data.dat");
        for (Student student : students) {
            if (student.getCode() == UpdateStudent.getCode()) {
                return false;
            }
        }
        students.add(UpdateStudent);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
        return true;
    }
}
