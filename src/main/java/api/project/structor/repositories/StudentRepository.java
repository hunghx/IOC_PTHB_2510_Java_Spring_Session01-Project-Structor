package api.project.structor.repositories;

import api.project.structor.entity.bt.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository // tao bean // ORM
public interface StudentRepository extends JpaRepository<Student,Long> {
    // Truy vấn dữ liệu trong JPA
    // Method Query : đặt tên -> tự tạo câu SQL

    // Sử dụng @Query để định nghĩa Câu lệnh : JPQL và SQL
    // Đếm số lượng sinh viên có tên >10 kí tự
//    @Query(nativeQuery = true,value = "Select count(*) from students where char_length(student_name)>10")
    @Query(value = "Select count(S) from Student S where length(S.name) > 10")
    Long countStudentByLengthName();

    @Query(value = "delete from Student where name ilike concat('%',:name,'%')")
    @Transactional
    @Modifying
    void deleteByName(@Param("name") String name);

    // Lưu ý : nếu truy vấn là DML : INSERT, UPDATE, DELETE thì phải thêm 2 chú thích : @Transactional, @Modify
}


// Serverside rendering(mọi thứ trả về từ BE) vs Clientside(JS : Angular, Vue, React) rendering
