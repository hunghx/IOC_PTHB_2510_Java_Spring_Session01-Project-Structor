package api.project.structor.repositories;

import api.project.structor.dto.CourseDto;
import api.project.structor.dto.ICourseDto;
import api.project.structor.entity.bt.Course;
import api.project.structor.entity.bt.CourseStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    boolean existsByIdAndStatus(Long id, CourseStatus status);
    Optional<Course> findByIdAndStatus(Long id, CourseStatus status);
//    - Lấy danh sách khóa học theo giảng viên

    @Query("from Course C where C.instructor.id = :id")
    List<Course> findAllByInstructor_Id(@Param("id") Long id);
    List<Course> findAllByStatus(CourseStatus status);
    @Modifying
    @Transactional
    @Query(value = "delete from Course  where status = :status")
    void deleteByStatus(@Param("status") CourseStatus status);

    @Query("select new api.project.structor.dto.CourseDto(id,title,status) From Course")
    List<CourseDto> findAllDto();

    @Query("From Course")
    List<ICourseDto> findAllDtoInterface();
}

