package repository;

import entity.Student;
import entity.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private static List<Teacher> teachers = new ArrayList<Teacher>();

    static {
//        teachers.add(new Teacher(1, "Lê Thị A", "Đà Nẵng", 27, "c8"));

        loadTeachersFromCSV();
    }

    private static void loadTeachersFromCSV() {
        try {
            File file = new File("Test/src/data/teachers.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                if (data.length == 5) {
                    int code = Integer.parseInt(data[0]);
                    String name = data[1];
                    String address = data[2];
                    int age = Integer.parseInt(data[3]);
                    String classWork = data[4];

                    Teacher teacher = new Teacher(code, name, address, age, classWork);
                    teachers.add(teacher);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

    public List<Teacher> getAll() {
        return teachers;
    }

    public boolean addTeacher(Teacher updateTeacher) {
        for (Teacher teacher : teachers) {
            if (teacher.getCode() == updateTeacher.getCode()) {
                return false;
            }
        }
        teachers.add(updateTeacher);
        return true;
    }
}
