package com.me.school_service.controller;

import com.me.school_service.client.StudentClient;
import com.me.school_service.dto.SchoolRequestDTO;
import com.me.school_service.dto.SchoolResponseDTO;
import com.me.school_service.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<SchoolResponseDTO> saveASchool(@RequestBody SchoolRequestDTO schoolRequestDTO){
        return new ResponseEntity<>(schoolService.saveASchool(schoolRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SchoolResponseDTO>> getAllSchoolsWithTheirStudents(){
        return new ResponseEntity<>(schoolService.getAllSchoolsWithTheirStudents(), HttpStatus.OK);
    }
}
