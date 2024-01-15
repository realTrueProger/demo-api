package com.isollo.demoapi.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {
}
