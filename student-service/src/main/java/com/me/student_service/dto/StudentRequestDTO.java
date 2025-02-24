package com.me.student_service.dto;

import java.time.LocalDate;

public record StudentRequestDTO(

        String firstname,

        String lastname,

        String phoneNumber,

        LocalDate birthdate,

        long schoolId

) {
}
