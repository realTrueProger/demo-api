package com.isollo.demoapi.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
