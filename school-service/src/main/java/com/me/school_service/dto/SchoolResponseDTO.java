package com.me.school_service.dto;

import java.util.List;

public record SchoolResponseDTO(

        long id,

        String name,

        List<StudentResponseDTO> studentResponseDTOList
) {
}
