/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author llnat
 */
@RestController
@RequestMapping(path="/api/v1/students")
public class StudentController {
    
    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studetservice) {
        this.studentservice = studetservice;
    }

    @GetMapping("/")
    public List<Student> getStudents() {
        return studentservice.getStudents();
    }

    @PostMapping("/")
    public void registerNewStudent(@RequestBody Student student) {
        studentservice.addNewStudent(student);
    }
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentservice.deleteStudent(studentId);
    }
    @PutMapping(path = "/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentservice.updateStudent(studentId, name, email);
        
    }
}
