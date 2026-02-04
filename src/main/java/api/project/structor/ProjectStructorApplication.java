package api.project.structor;


import api.project.structor.dto.CourseDto;
import api.project.structor.dto.ICourseDto;
import api.project.structor.repositories.ICourseRepository;
import api.project.structor.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProjectStructorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectStructorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository, ICourseRepository courseRepository) {
        return args -> {
            System.out.println(studentRepository.countStudentByLengthName());
            studentRepository.deleteByName("Van");
            List<CourseDto> courseDtos = courseRepository.findAllDto();

            List<ICourseDto> courseDtos1 = courseRepository.findAllDtoInterface();

            for (ICourseDto course : courseDtos1) {
                System.out.println(course.getTitle());
            }

            api.project.structor.dto.CourseDto courseDto = new api.project.structor.dto.CourseDto();
        };
    }

}
