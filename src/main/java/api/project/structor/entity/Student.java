package api.project.structor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student { //  đại diện cho dữ liệu
    @Id
    private String studentId;
    private String studentName;
    private LocalDate birthDate;
    private String email;

//    private Classes classes;
}
