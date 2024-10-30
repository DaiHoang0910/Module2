package controller;

import entity.Teacher;
import service.ITeacherService;
import service.impl.TeacherService;

import java.util.List;

public class TeacherController {
    private static ITeacherService teacherService = new TeacherService();

    public List<Teacher> getAll() {
        List<Teacher> teachers = teacherService.getAll();
        return teachers;
    }
    public boolean addTeacher(Teacher teacher) {
        return teacherService.add(teacher);
    }
}
