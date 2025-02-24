package com.me.school_service.dto;

import java.time.LocalDate;

public record StudentResponseDTO(
        long id,

        String firstname,

        String lastname,

        String phoneNumber,

        LocalDate birthdate

        //long schoolId
) {
}
