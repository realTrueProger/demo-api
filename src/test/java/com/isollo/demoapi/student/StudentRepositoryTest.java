package com.isollo.demoapi.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindStudentByEmailNative() {
        // Given
        String mail = "vovasollo@yandex.ru";
        Student student = new Student("Vladimir", "Solovev", mail, 36);

        // When
        underTest.save(student);

        // Then
        Optional<Student> byEmail = underTest.findStudentByEmailNative(mail);
        assertThat(byEmail).isPresent();

    }

    @Test
    void itShouldSaveStudent() {
        // Given
        Student student = new Student("Vladimir", "Solovev", "vovasollo@yandex.ru", 36);

        // When
        underTest.save(student);

        // Then
        Optional<Student> byId = underTest.findById(2L);
        assertThat(byId)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c.getAge()).isEqualTo(36);
                    assertThat(c.getFirstName()).isEqualTo("Vladimir");
                });
    }

    @Test
    void itShouldBeEmpty() {
        assertThat(underTest.count()).isEqualTo(0);
    }
}