package com.registration_system_backend.api_rest_registration_system.serviceimpl;

import com.registration_system_backend.api_rest_registration_system.dto.PersonDTO;
import com.registration_system_backend.api_rest_registration_system.enums.CivilStatus;
import com.registration_system_backend.api_rest_registration_system.enums.Gender;
import com.registration_system_backend.api_rest_registration_system.model.Person;
import com.registration_system_backend.api_rest_registration_system.repository.PersonRepository;
import com.registration_system_backend.api_rest_registration_system.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDTO getPersonById(UUID id) {
        Person person = personRepository.findById(id).orElse(null);
        return convertToDTO(person);
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = convertToEntity(personDTO);
        Person savedPerson = personRepository.save(person);
        return convertToDTO(savedPerson);
    }
    private PersonDTO convertToDTO(Person person) {
        if (person == null) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonId(person.getPersonId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setSecondName(person.getSecondName());
        personDTO.setSurname(person.getSurname());
        personDTO.setSecondSurname(person.getSecondSurname());
        personDTO.setDni(person.getDni());
        personDTO.setBirthDate(person.getBirthDate());
        personDTO.setGender(String.valueOf(person.getGender()));
        personDTO.setCivilStatus(String.valueOf(person.getCivilStatus()));
        personDTO.setPhone(person.getPhone());
        personDTO.setMail(person.getMail());
        personDTO.setCity(person.getCity());
        personDTO.setDepartment(person.getDepartment());
        personDTO.setCountry(person.getCountry());
        personDTO.setAddress(person.getAddress());
        personDTO.setProfileImage(person.getProfileImage());
        personDTO.setUsername(person.getUsername());
        personDTO.setPassword(person.getPassword());
        personDTO.setStatusUser(person.isStatusUser());
        personDTO.setCreatedAt(person.getCreatedAt());
        personDTO.setUpdatedAt(person.getUpdatedAt());
        personDTO.setRegisteredBy(person.getRegisteredBy());
        personDTO.setUpdatedBy(person.getUpdatedBy());
        personDTO.setRegistrationStatus(person.isRegistrationStatus());

        return personDTO;
    }

    private Person convertToEntity(PersonDTO personDTO) {
        if (personDTO == null) {
            return null;
        }

        Person person = new Person();
        person.setPersonId(personDTO.getPersonId());
        person.setFirstName(personDTO.getFirstName());
        person.setSecondName(personDTO.getSecondName());
        person.setSurname(personDTO.getSurname());
        person.setSecondSurname(personDTO.getSecondSurname());
        person.setDni(personDTO.getDni());
        person.setBirthDate(personDTO.getBirthDate());
        person.setGender(Gender.valueOf(personDTO.getGender()));
        person.setCivilStatus(CivilStatus.valueOf(personDTO.getCivilStatus()));
        person.setPhone(personDTO.getPhone());
        person.setMail(personDTO.getMail());
        person.setCity(personDTO.getCity());
        person.setDepartment(personDTO.getDepartment());
        person.setCountry(personDTO.getCountry());
        person.setAddress(personDTO.getAddress());
        person.setProfileImage(personDTO.getProfileImage());
        person.setUsername(personDTO.getUsername());
        person.setPassword(personDTO.getPassword());
        person.setStatusUser(personDTO.getStatusUser());
        person.setCreatedAt(personDTO.getCreatedAt());
        person.setUpdatedAt(personDTO.getUpdatedAt());
        person.setRegisteredBy(personDTO.getRegisteredBy());
        person.setUpdatedBy(personDTO.getUpdatedBy());
        person.setRegistrationStatus(personDTO.getRegistrationStatus());

        return person;
    }
}
