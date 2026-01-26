package api.project.structor.services;

import api.project.structor.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(String id);
    Student add(Student student);
    Student update(Student student, String id);
    void deleteById(String id);
}
