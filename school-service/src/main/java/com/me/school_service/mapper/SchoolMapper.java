package com.me.school_service.mapper;

import com.me.school_service.dto.SchoolRequestDTO;
import com.me.school_service.dto.SchoolResponseDTO;
import com.me.school_service.dto.StudentResponseDTO;
import com.me.school_service.entity.School;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolMapper {

    public static School toSchool(SchoolRequestDTO schoolRequestDTO){
        return new School(
                schoolRequestDTO.name()
        );
    }
    public static SchoolResponseDTO toSchoolResponseDTO(School school){

        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();

        return new SchoolResponseDTO(
                school.getId(),
                school.getName(),
                studentResponseDTOList
        );
    }
}
