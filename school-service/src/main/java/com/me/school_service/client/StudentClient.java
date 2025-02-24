package com.me.school_service.client;

import com.me.school_service.dto.StudentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/school/{schoolId}")
    List<StudentResponseDTO> getAllSchoolStudents(@PathVariable("schoolId") long schoolId);
}
