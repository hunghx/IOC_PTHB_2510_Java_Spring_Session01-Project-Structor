package api.project.structor.controllers;

import api.project.structor.entity.Student;
import api.project.structor.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    // @RequestMapping : GetMapping, PostMapping, PutMapping, DeleteMapping
    // @ModelAttribute : lấy dữ liệu từ form , @RequestBody : lấy dữ liệu từ json (POST và PUT)
    // @RequestParam : lấy dữ liệu từ queryString(URL)
    // @PathVariable : lấy dữ liệu từ đường dẫn(URL)
    @Autowired
    private IStudentService studentService;
    // lấy danh sách
    @RequestMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    // lấy theo id
    @RequestMapping("/student-details")
    public Student getStudentById(@RequestParam String id){
        return studentService.findById(id);
    }

    // THêm mới : post
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student){
        return  studentService.add(student);
    }

}
