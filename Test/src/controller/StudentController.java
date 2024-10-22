package controller;

import service.IStudentService;
import service.impl.StudentService;
import entity.Student;

public class StudentController {
    private static IStudentService studentService = new StudentService();

    public Student[] getAll() {
        Student[] students = studentService.getAll();
        return students;
    }
}
