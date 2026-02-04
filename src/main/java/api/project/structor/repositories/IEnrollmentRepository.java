package api.project.structor.repositories;

import api.project.structor.entity.bt.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEnrollmentRepository extends JpaRepository<StudentEnrollment, Long> {
    boolean existsByCourse_IdAndStudent_Id(Long course_Id, Long student_Id);
    List<StudentEnrollment> findAllByStudent_NameContainingIgnoreCase(String name);
}
