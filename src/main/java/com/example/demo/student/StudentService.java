/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author llnat
 */
@Service
public class StudentService {
    private final StudentRepository studentrepository;


    @Autowired
    public StudentService(StudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    public List<Student> getStudents() {

        return studentrepository.findAll();
    }
    
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentrepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentrepository.save(student);
    }
    public void deleteStudent(Long studentId){
        
        boolean exists = studentrepository.existsById(studentId);
        
        if(!exists){ throw new IllegalStateException("Student with id " + studentId + " does not exist");}
        studentrepository.deleteById(studentId);
    }
    
    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentrepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
        
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentrepository.findStudentByEmail(student.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
