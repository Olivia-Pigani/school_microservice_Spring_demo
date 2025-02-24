package com.me.student_service.repository;

import com.me.student_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentBySchoolId(long schoolId);
}
