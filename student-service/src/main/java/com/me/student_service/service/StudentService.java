package com.me.student_service.service;

import com.me.student_service.dto.StudentRequestDTO;
import com.me.student_service.dto.StudentResponseDTO;
import com.me.student_service.entity.Student;
import com.me.student_service.mapper.StudentMapper;
import com.me.student_service.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO saveAStudent(StudentRequestDTO studentRequestDTO) {
        Student newStudent = StudentMapper.toStudent(studentRequestDTO);

        Student saveStudent = studentRepository.save(newStudent);

        return StudentMapper.toStudentResponseDTO(saveStudent);
    }

    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        return StudentMapper.toStudentResponseDTOList(studentList);
    }

    public List<StudentResponseDTO> getAllStudentsBySchoolId(long schoolId) {
        List<Student> studentList = studentRepository.findStudentBySchoolId(schoolId);

        return StudentMapper.toStudentResponseDTOList(studentList);
    }
}
