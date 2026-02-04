package api.project.structor;

import api.project.structor.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectStructorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectStructorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            System.out.println(studentRepository.countStudentByLengthName());
            studentRepository.deleteByName("Van");
        };
    }

}
