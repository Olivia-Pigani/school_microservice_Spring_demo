package com.me.student_service.mapper;

import com.me.student_service.dto.StudentRequestDTO;
import com.me.student_service.dto.StudentResponseDTO;
import com.me.student_service.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMapper {

    public static Student toStudent(StudentRequestDTO studentRequestDTO) {
        return new Student(
                studentRequestDTO.firstname(),
                studentRequestDTO.lastname(),
                studentRequestDTO.phoneNumber(),
                studentRequestDTO.birthdate(),
                studentRequestDTO.schoolId()
        );
    }

    public static StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getPhoneNumber(),
                student.getBirthdate(),
                student.getSchoolId()
        );
    }

    public static List<StudentResponseDTO> toStudentResponseDTOList(List<Student> studentList) {
        return studentList.stream()
                .map(StudentMapper::toStudentResponseDTO)
                .toList();
    }
}
