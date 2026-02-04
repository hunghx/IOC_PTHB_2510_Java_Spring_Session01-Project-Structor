package api.project.structor.services;

import api.project.structor.dto.CourseEnrollmentRequest;
import api.project.structor.dto.CourseEnrollmentResponse;
import api.project.structor.entity.bt.Course;
import api.project.structor.entity.bt.CourseStatus;
import api.project.structor.entity.bt.Student;
import api.project.structor.entity.bt.StudentEnrollment;
import api.project.structor.repositories.ICourseRepository;
import api.project.structor.repositories.IEnrollmentRepository;
import api.project.structor.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentEnrollmentServiceImpl implements IStudentEnrollmentSevice{
    private final StudentRepository studentRepository;
    private final ICourseRepository courseRepository;
    private final IEnrollmentRepository enrollmentRepository;
    @Override
    public CourseEnrollmentResponse enroll(Long courseId, CourseEnrollmentRequest request) {
        Student s = studentRepository.findById(request.getStudentId()).orElseThrow(() -> new RuntimeException("Student id not exists"));
        Course c = courseRepository.findByIdAndStatus(courseId, CourseStatus.active).orElseThrow(() -> new RuntimeException("Course id not exists"));

        // kiểm tra sinh viên đã dăng kí chưa
        if(enrollmentRepository.existsByCourse_IdAndStudent_Id(courseId,request.getStudentId())){
            throw new RuntimeException("Enrollment already exists");
        }
        StudentEnrollment studentEnrollment = new StudentEnrollment(null,
                c, s, null);
        StudentEnrollment se = enrollmentRepository.save(studentEnrollment);
        Pageable pageable = PageRequest.of(2,1);
        Sort sort = Sort.by(Sort.Direction.ASC, "enrollmentDate");
        return new CourseEnrollmentResponse(request.getStudentId(),courseId,se.getEnrollAt());



    }
}
