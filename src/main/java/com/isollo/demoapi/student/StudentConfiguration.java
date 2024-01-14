package com.isollo.demoapi.student;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class StudentConfiguration {
    @Bean
    CommandLineRunner studentConfig(StudentRepository studentRepository) {
        return args -> {
            Faker faker = new Faker();

            for (int i = 0; i < 20; i++) {
                Student student = new Student(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.name().firstName() + "@mail.ru",
                        faker.number().numberBetween(18, 55)
                );

                studentRepository.save(student);
            }

//            studentRepository.findById(3L).ifPresentOrElse(
//                    System.out::println,
//                    () -> System.out.println("Student with id 3 not found")
//            );
//
//            System.out.println("query result :");
//            studentRepository.findStudentByEmailNative("vova@yandex.ru").ifPresentOrElse(
//                    System.out::println,
//                    () -> System.out.println("Student with email vova@yandex.ru not found")
//            );
        };
    }
}
