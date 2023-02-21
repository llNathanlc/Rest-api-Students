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
            Student xxxx = new Student("xxx","xxx", LocalDate.of(1900, FEBRUARY, 01));
            Student xxxx = new Student("xxx","xxxx",LocalDate.of(1900,FEBRUARY,01));
            
     
        repository.saveAll(
        List.of(luis,andrea));
        };
    }
}
