package api.project.structor.services;

import api.project.structor.dto.CourseEnrollmentRequest;
import api.project.structor.dto.CourseEnrollmentResponse;

public interface IStudentEnrollmentSevice {
    CourseEnrollmentResponse enroll(Long courseId, CourseEnrollmentRequest request);
}
