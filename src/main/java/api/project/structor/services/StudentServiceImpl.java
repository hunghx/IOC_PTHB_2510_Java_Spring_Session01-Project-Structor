package api.project.structor.services;

import api.project.structor.entity.Student;
//import api.project.structor.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class StudentServiceImpl implements IStudentService{
//    @Autowired
//    private StudentRepository studentRepository;
//    @Override
//    public List<Student> findAll() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    public Student findById(String id) {
//        return studentRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Student add(Student student) {
//        return studentRepository.save(student);
//    }
//
//    @Override
//    public Student update(Student student, String id) {
//        if (studentRepository.existsById(id)){
//            return studentRepository.save(student);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteById(String id) {
//        if (studentRepository.existsById(id)){
//            studentRepository.deleteById(id);
//        }
//    }
//}
