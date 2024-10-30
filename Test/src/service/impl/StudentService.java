package service.impl;

import repository.StudentRepository;
import service.IStudentService;
import entity.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService implements IStudentService {
    private static StudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.getAll();
        return students;
    }

    @Override
    public void save(Student s) {

    }

    @Override
    public void update(int id, Student s) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean add(Student s) {
        return studentRepository.addStudent(s);
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> students = studentRepository.getAll();
        List<Student> temp = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                temp.add(student);
            }
        }
        return temp;
    }


}
