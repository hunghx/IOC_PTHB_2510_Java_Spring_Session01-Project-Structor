package api.project.structor.controllers;

import api.project.structor.dto.CourseEnrollmentRequest;
import api.project.structor.dto.CourseEnrollmentResponse;
import api.project.structor.services.IStudentEnrollmentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class StudentEnrollmentController {
    @Autowired
    private IStudentEnrollmentSevice studentEnrollmentSevice;
    @PostMapping("/{courseId}/enrollments")
    public ResponseEntity<CourseEnrollmentResponse> enroll(@PathVariable Long courseId,
                                                           @RequestBody CourseEnrollmentRequest request){
        return new ResponseEntity<>(studentEnrollmentSevice.enroll(courseId, request), HttpStatus.OK); // 201
    }
}
