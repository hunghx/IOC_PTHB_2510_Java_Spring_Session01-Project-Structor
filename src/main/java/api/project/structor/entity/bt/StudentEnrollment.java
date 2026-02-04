package api.project.structor.entity.bt;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_enrollments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Getters & Setters

    private LocalDateTime enrollAt;
    @PrePersist
    public void onCreate(){
        this.enrollAt = LocalDateTime.now();
    }
}