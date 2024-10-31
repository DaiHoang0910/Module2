package controller;

import service.IStudentService;
import service.impl.StudentService;
import entity.Student;

import java.util.List;

public class StudentController {
    private static IStudentService studentService = new StudentService();

    public List<Student> getAll() {
        List<Student> students = studentService.getAll();
        return students;
    }

    public List<Student> searchByName(String name) {
        return studentService.findByName(name);
    }

    public boolean addStudent(Student UpdateStudent) {
        return studentService.add(UpdateStudent);
    }

    public List<Student> displayAllStudentSortById() {
        return studentService.getAllSortById();
    }

}
