package com.konsta.student.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.konsta.student.data.Course;
import com.konsta.student.data.Student;
import com.konsta.student.service.StudentService;

@RestController
public class StudentsController {

    @Autowired
    StudentService pService;

   @GetMapping("students")//Etsii kaikki opiskelijat ja tallentaa ne samalla txt.tiedostoon.
    public List<Student> getStudents() throws IOException{
        pService.SaveToFile();
        return pService.students;
    }

    @GetMapping("courses")//Etsii kaikki kurssit
    public List<Course> getCourses(){
        return pService.courses;
    }

    @GetMapping("student/{id}")//Voi etsiä opiskelijan tietoja id:llä
    public List<Student> getStudentById(@PathVariable long id){
        return pService.getStudentById(id);
    }

    @PostMapping("addCourse")//Tekee uuden kurssin
    public String addCourse(@RequestBody Course course ){

        pService.courses.add(course);
        return "Course added";
    }

    @PostMapping("addStudent")//Tekee uuden opiskelijan
    public String addStudent(@RequestBody Student student ){
        pService.students.add(student);
        return "Student added";
    }

    @DeleteMapping("student/delete/{id}")//poistaa opiskelijan syöttämällä id:n
    public void deleteStudentById(@PathVariable long id){
        pService.deleteStudentById(id);
    }
    
}
    

