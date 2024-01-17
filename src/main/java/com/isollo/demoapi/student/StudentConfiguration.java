package com.isollo.demoapi.student;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class StudentConfiguration {
    @Bean
    CommandLineRunner studentConfig(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository,
            BookRepository bookRepository
    ) {
        return args -> {
            Faker faker = new Faker();

            Student student = new Student(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.name().firstName() + "@mail.ru",
                    faker.number().numberBetween(18, 55)
            );

            //studentRepository.save(student);
            studentIdCardRepository.save(new StudentIdCard("12345", student));
            studentRepository.deleteById(1L);
        };
    }

    private static void paginationExample(StudentRepository studentRepository) {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("id").ascending());
        Page<Student> page = studentRepository.findAll(pageRequest);
        page.getContent().forEach(System.out::println);
    }

    private static void sortingExample(StudentRepository studentRepository) {
        studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"))
                .forEach(System.out::println);
    }

    private static void playGround(StudentRepository studentRepository) {
        studentRepository.findById(3L).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Student with id 3 not found")
        );

        System.out.println("query result :");
        studentRepository.findStudentByEmailNative("vova@yandex.ru").ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Student with email vova@yandex.ru not found")
        );
    }

    private static void generateStudents(StudentRepository studentRepository) {
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            Student student = new Student(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.name().firstName() + "@mail.ru",
                    faker.number().numberBetween(18, 55)
            );

            studentRepository.save(student);
        }
    }
}
