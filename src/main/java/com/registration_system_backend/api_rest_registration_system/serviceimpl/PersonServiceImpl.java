package com.registration_system_backend.api_rest_registration_system.serviceimpl;

import com.registration_system_backend.api_rest_registration_system.dto.PersonDTO;
import com.registration_system_backend.api_rest_registration_system.enums.CivilStatus;
import com.registration_system_backend.api_rest_registration_system.enums.Gender;
import com.registration_system_backend.api_rest_registration_system.model.PersonModel;
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
        PersonModel personModel = personRepository.findById(id).orElse(null);
        return convertToDTO(personModel);
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        PersonModel personModel = convertToEntity(personDTO);
        PersonModel savedPersonModel = personRepository.save(personModel);
        return convertToDTO(savedPersonModel);
    }
    private PersonDTO convertToDTO(PersonModel personModel) {
        if (personModel == null) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonId(personModel.getPersonId());
        personDTO.setFirstName(personModel.getFirstName());
        personDTO.setSecondName(personModel.getSecondName());
        personDTO.setSurname(personModel.getSurname());
        personDTO.setSecondSurname(personModel.getSecondSurname());
        personDTO.setDni(personModel.getDni());
        personDTO.setBirthDate(personModel.getBirthDate());
        personDTO.setGender(String.valueOf(personModel.getGender()));
        personDTO.setCivilStatus(String.valueOf(personModel.getCivilStatus()));
        personDTO.setPhone(personModel.getPhone());
        personDTO.setMail(personModel.getMail());
        personDTO.setCity(personModel.getCity());
        personDTO.setDepartment(personModel.getDepartment());
        personDTO.setCountry(personModel.getCountry());
        personDTO.setAddress(personModel.getAddress());
        personDTO.setProfileImage(personModel.getProfileImage());
        personDTO.setUsername(personModel.getUsername());
        personDTO.setPassword(personModel.getPassword());
        personDTO.setStatusUser(personModel.isStatusUser());
        personDTO.setCreatedAt(personModel.getCreatedAt());
        personDTO.setUpdatedAt(personModel.getUpdatedAt());
        personDTO.setRegisteredBy(personModel.getRegisteredBy());
        personDTO.setUpdatedBy(personModel.getUpdatedBy());
        personDTO.setRegistrationStatus(personModel.isRegistrationStatus());

        return personDTO;
    }

    private PersonModel convertToEntity(PersonDTO personDTO) {
        if (personDTO == null) {
            return null;
        }

        PersonModel personModel = new PersonModel();
        personModel.setPersonId(personDTO.getPersonId());
        personModel.setFirstName(personDTO.getFirstName());
        personModel.setSecondName(personDTO.getSecondName());
        personModel.setSurname(personDTO.getSurname());
        personModel.setSecondSurname(personDTO.getSecondSurname());
        personModel.setDni(personDTO.getDni());
        personModel.setBirthDate(personDTO.getBirthDate());
        personModel.setGender(Gender.valueOf(personDTO.getGender()));
        personModel.setCivilStatus(CivilStatus.valueOf(personDTO.getCivilStatus()));
        personModel.setPhone(personDTO.getPhone());
        personModel.setMail(personDTO.getMail());
        personModel.setCity(personDTO.getCity());
        personModel.setDepartment(personDTO.getDepartment());
        personModel.setCountry(personDTO.getCountry());
        personModel.setAddress(personDTO.getAddress());
        personModel.setProfileImage(personDTO.getProfileImage());
        personModel.setUsername(personDTO.getUsername());
        personModel.setPassword(personDTO.getPassword());
        personModel.setStatusUser(personDTO.getStatusUser());
        personModel.setCreatedAt(personDTO.getCreatedAt());
        personModel.setUpdatedAt(personDTO.getUpdatedAt());
        personModel.setRegisteredBy(personDTO.getRegisteredBy());
        personModel.setUpdatedBy(personDTO.getUpdatedBy());
        personModel.setRegistrationStatus(personDTO.getRegistrationStatus());

        return personModel;
    }
}
