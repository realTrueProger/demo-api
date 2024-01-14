package com.isollo.demoapi.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // JPQL
    @Query("SELECT s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    // native query example
    @Query(value = "SELECT * from student where email = ?1", nativeQuery = true)
    Optional<Student> findStudentByEmailNative(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s where s.id = ?1")
    int deleteStudentById(Long id);
}
