package com.me.school_service.service;

import com.me.school_service.client.StudentClient;
import com.me.school_service.dto.SchoolRequestDTO;
import com.me.school_service.dto.SchoolResponseDTO;
import com.me.school_service.entity.School;
import com.me.school_service.mapper.SchoolMapper;
import com.me.school_service.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public SchoolService(SchoolRepository schoolRepository, StudentClient studentClient) {
        this.schoolRepository = schoolRepository;
        this.studentClient = studentClient;
    }

    public SchoolResponseDTO saveASchool(SchoolRequestDTO schoolRequestDTO){
        School newSchool = SchoolMapper.toSchool(schoolRequestDTO);

        School savedSchool = schoolRepository.save(newSchool);

        return SchoolMapper.toSchoolResponseDTO(savedSchool);
    }

    public List<SchoolResponseDTO> getAllSchoolsWithTheirStudents() {
        List<School> schoolList = schoolRepository.findAll();

        List<SchoolResponseDTO> schoolResponseDTOList = schoolList.stream()
                .map(SchoolMapper::toSchoolResponseDTO)
                .toList();

        schoolResponseDTOList = schoolResponseDTOList.stream()
                .map(schoolDTO -> new SchoolResponseDTO(
                        schoolDTO.id(),
                        schoolDTO.name(),
                        studentClient.getAllSchoolStudents(schoolDTO.id())
                ))
                .toList();

        return schoolResponseDTOList;
    }

}
