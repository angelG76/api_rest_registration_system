package com.registration_system_backend.api_rest_registration_system.service;

import com.registration_system_backend.api_rest_registration_system.dto.PersonDTO;
import com.registration_system_backend.api_rest_registration_system.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface StudentService {
    StudentDTO getStudentById(UUID studentId);
    StudentDTO createStudent(StudentDTO studentDTO, PersonDTO personDTO);
}
