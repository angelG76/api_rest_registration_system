package com.registration_system_backend.api_rest_registration_system.serviceimpl;

import com.registration_system_backend.api_rest_registration_system.dto.PersonDTO;
import com.registration_system_backend.api_rest_registration_system.dto.StudentDTO;
import com.registration_system_backend.api_rest_registration_system.enums.CivilStatus;
import com.registration_system_backend.api_rest_registration_system.enums.Gender;
import com.registration_system_backend.api_rest_registration_system.model.Person;
import com.registration_system_backend.api_rest_registration_system.model.Student;
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
        Student student = studentRepository.findById(id).orElse(null);
        return convertToDTO(student);
    }
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO, PersonDTO personDTO) {
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

        person = personRepository.save(person);


        // Crear la entidad Student y asociar la Person
        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setCreatedAt(studentDTO.getCreatedAt());
        student.setUpdatedAt(studentDTO.getUpdatedAt());
        student.setPerson(person);

        // Guardar la entidad Student
        Student savedStudent = studentRepository.save(student);

        // Convertir la entidad Student a DTO para devolver
        return convertToDTO(savedStudent);
    }

    private StudentDTO convertToDTO(Student student) {
        if (student == null) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setPersonId(student.getPerson().getPersonId());
        studentDTO.setCreatedAt(student.getCreatedAt());
        studentDTO.setUpdatedAt(student.getUpdatedAt());

        return studentDTO;
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setCreatedAt(studentDTO.getCreatedAt());
        student.setUpdatedAt(studentDTO.getUpdatedAt());

        // Buscar la entidad Person por ID
        //Person person = personRepository.findById(studentDTO.getPersonId()).orElse(null);
        //student.setPersonId(person);

        return student;
    }
}
