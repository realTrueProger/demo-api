package com.isollo.demoapi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class StudentConfiguration {
    @Bean
    CommandLineRunner studentConfig(StudentRepository studentRepository) {
        return args -> {
            Student vladimir = new Student(
                    "Vladimir",
                    "Solovev",
                    "vova@yandex.ru",
                    36
            );
            studentRepository.save(vladimir);

            studentRepository.findById(3L).ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Student with id 3 not found")
            );
        };
    }
}
