package api.project.structor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEnrollmentResponse {
    private Long studentId;
    private  Long courseId;
    private LocalDateTime enrollAt;
}
