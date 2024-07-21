package com.registration_system_backend.api_rest_registration_system.controller;

import com.registration_system_backend.api_rest_registration_system.dto.ApiResponse;
import com.registration_system_backend.api_rest_registration_system.dto.PersonDTO;
import com.registration_system_backend.api_rest_registration_system.dto.StudentDTO;
import com.registration_system_backend.api_rest_registration_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/service/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Endpoint para obtener un estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> getStudentById(@PathVariable("id") UUID id) {
        try {
            StudentDTO studentDTO = studentService.getStudentById(id);
            if (studentDTO != null) {
                ApiResponse<StudentDTO> response = new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Datos obtenidos",
                        "Datos obtenidos",
                        studentDTO
                );
                return ResponseEntity.ok(response);
            } else {
                ApiResponse<StudentDTO> response = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Estudiante no ",
                        "No se encontró un estudiante con el ID proporcionado",
                        null
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            ApiResponse<StudentDTO> response = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Error interno",
                    "Se produjo un error interno en el servidor",
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(
            @RequestBody StudentDTO studentDTO,
            @RequestBody PersonDTO personDTO) {

        try {
            StudentDTO createdStudent = studentService.createStudent(studentDTO, personDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
