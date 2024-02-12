package com.faidterence.springbootlearn.student;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents () {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent (@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId")Integer studentId, @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
    }

    @GetMapping(path = "{studentId}")
    public void getStudentById(@PathVariable("studentId") Integer studentId){
        studentService.getStudentById(studentId);
    }





}
