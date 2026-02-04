package api.project.structor.repositories;

import api.project.structor.entity.bt.Course;
import api.project.structor.entity.bt.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    boolean existsByIdAndStatus(Long id, CourseStatus status);
    Optional<Course> findByIdAndStatus(Long id, CourseStatus status);
}
