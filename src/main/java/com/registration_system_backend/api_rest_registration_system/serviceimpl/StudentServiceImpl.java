package com.registration_system_backend.api_rest_registration_system.serviceimpl;

import com.registration_system_backend.api_rest_registration_system.dto.PersonDTO;
import com.registration_system_backend.api_rest_registration_system.dto.StudentDTO;
import com.registration_system_backend.api_rest_registration_system.enums.CivilStatus;
import com.registration_system_backend.api_rest_registration_system.enums.Gender;
import com.registration_system_backend.api_rest_registration_system.model.PersonModel;
import com.registration_system_backend.api_rest_registration_system.model.StudentModel;
import com.registration_system_backend.api_rest_registration_system.repository.PersonRepository;
import com.registration_system_backend.api_rest_registration_system.repository.StudentRepository;
import com.registration_system_backend.api_rest_registration_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PersonRepository personRepository;
    @Override
    public StudentDTO getStudentById(UUID id) {
        StudentModel studentModel = studentRepository.findById(id).orElse(null);
        return convertToDTO(studentModel);
    }
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO, PersonDTO personDTO) {
        PersonModel personModel = new PersonModel();
        //personModel.setPersonId(personDTO.getPersonId());
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

        personModel = personRepository.save(personModel);


        // Crear la entidad Student y asociar la Person
        StudentModel studentModel = new StudentModel();
        //studentModel.setStudentId(studentDTO.getStudentId());
        studentModel.setCreatedAt(studentDTO.getCreatedAt());
        studentModel.setUpdatedAt(studentDTO.getUpdatedAt());
        studentModel.setPersonModel(personModel);

        // Guardar la entidad Student
        StudentModel savedStudentModel = studentRepository.save(studentModel);

        // Convertir la entidad Student a DTO para devolver
        return convertToDTO(savedStudentModel);
    }

    private StudentDTO convertToDTO(StudentModel studentModel) {
        if (studentModel == null) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(studentModel.getStudentId());
        studentDTO.setPersonId(studentModel.getPersonModel().getPersonId());
        studentDTO.setCreatedAt(studentModel.getCreatedAt());
        studentDTO.setUpdatedAt(studentModel.getUpdatedAt());

        return studentDTO;
    }

    private StudentModel convertToEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        StudentModel studentModel = new StudentModel();
        studentModel.setStudentId(studentDTO.getStudentId());
        studentModel.setCreatedAt(studentDTO.getCreatedAt());
        studentModel.setUpdatedAt(studentDTO.getUpdatedAt());

        // Buscar la entidad Person por ID
        //Person person = personRepository.findById(studentDTO.getPersonId()).orElse(null);
        //student.setPersonId(person);

        return studentModel;
    }
}
