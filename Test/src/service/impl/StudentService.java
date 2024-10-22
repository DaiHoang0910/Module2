package service.impl;

import repository.StudentRepository;
import service.IStudentService;
import entity.Student;

public class StudentService implements IStudentService {
    private static StudentRepository studentRepository = new StudentRepository();

    @Override
    public Student[] getAll() {
        Student[] students = studentRepository.getAll();
        return students;
    }
}
