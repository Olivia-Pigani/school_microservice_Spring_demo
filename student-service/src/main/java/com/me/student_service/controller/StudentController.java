package com.me.student_service.controller;

import com.me.student_service.dto.StudentRequestDTO;
import com.me.student_service.dto.StudentResponseDTO;
import com.me.student_service.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> saveAStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return new ResponseEntity<>(studentService.saveAStudent(studentRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudentsBySchoolId(@PathVariable("schoolId") long schoolId){
        return new ResponseEntity<>(studentService.getAllStudentsBySchoolId(schoolId), HttpStatus.OK);
    }
}

