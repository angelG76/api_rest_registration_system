package com.registration_system_backend.api_rest_registration_system.service;

import com.registration_system_backend.api_rest_registration_system.dto.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PersonService {
    PersonDTO getPersonById(UUID personId);

    PersonDTO createPerson(PersonDTO personDTO);
}
