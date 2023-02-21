/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import static java.time.Month.*;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author llnat
 */
@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student luis = new Student("Luis","luis_jcamacho@hotmail.com", LocalDate.of(1996, SEPTEMBER, 28));
            Student andrea = new Student("Andrea","mugarrr@gmail.com",LocalDate.of(2003,FEBRUARY,11));
            
     
        repository.saveAll(
        List.of(luis,andrea));
        };
    }
}
