package api.project.structor.repositories;

import api.project.structor.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // tao bean // ORM
public interface StudentRepository extends JpaRepository<Student,String> {

}

// Serverside rendering(mọi thứ trả về từ BE) vs Clientside(JS : Angular, Vue, React) rendering
