package api.project.structor.repositories;

import api.project.structor.entity.bt.Student;
import api.project.structor.entity.bt.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEnrollmentRepository extends JpaRepository<StudentEnrollment, Long> {
    boolean existsByCourse_IdAndStudent_Id(Long course_Id, Long student_Id);
    List<StudentEnrollment> findAllByStudent_NameContainingIgnoreCase(String name);
// Lấy danh sách đăng kí môn theo Khóa học
    @Query("From StudentEnrollment where course.id = :id")
    List<StudentEnrollment> findAllByCourse_Id(@Param("id") Long courseId);
//    Lấy danh sách sinh viên theo Khóa học
    @Query("Select S.student from StudentEnrollment S WHERE S.course.id = :courseId")
    List<Student> findByStudentByCourseId(@Param("courseId") Long courseId);


}
