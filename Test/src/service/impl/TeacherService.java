package service.impl;

import entity.Teacher;
import repository.TeacherRepository;
import service.ITeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService {
    private static TeacherRepository teacherRepository = new TeacherRepository();

    @Override
    public List<Teacher> getAll() {
        List<Teacher> teachers = teacherRepository.getAll();
        return teachers;
    }

    @Override
    public List<Teacher> getAllSortById() {
        return List.of();
    }
    @Override
    public boolean add(Teacher s) {
        return teacherRepository.addTeacher(s);
    }

    @Override
    public List<Teacher> findByName(String name) {
        return List.of();
    }
}
