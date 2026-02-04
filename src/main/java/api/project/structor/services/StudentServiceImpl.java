package api.project.structor.services;

import api.project.structor.dto.PageDto;
import api.project.structor.entity.Student;
//import api.project.structor.repositories.StudentRepository;
import api.project.structor.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;
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

    @Override
    public List<Student> findAll(PageDto pageDto) {
        // Biến đổi DTO -> Page able
        Sort sort;
        if (pageDto.getSortBy() == null || pageDto.getSortBy().isBlank()){
            sort = Sort.by("id");
        }else {
            sort = Sort.by(pageDto.getSortBy());
        }

        // chiều sắp xếp
        if (pageDto.getDirection()==null || pageDto.getDirection().equalsIgnoreCase("DESC")){
            sort = sort.ascending();
        }else {
            sort = sort.descending();
        }

        if (pageDto.getPage() == null){
            pageDto.setPage(0);
        }
        if (pageDto.getSize() == null){
            pageDto.setSize(10);
        }
        Pageable pageable = PageRequest.of(pageDto.getPage(),pageDto.getSize(),sort);

        Page<api.project.structor.entity.bt.Student> page = studentRepository.findAll(pageable);

        return List.of();
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public Student add(Student student) {
        return null;
    }

    @Override
    public Student update(Student student, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
