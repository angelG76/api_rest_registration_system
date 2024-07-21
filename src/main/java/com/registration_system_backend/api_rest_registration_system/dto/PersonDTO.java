package com.registration_system_backend.api_rest_registration_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private UUID personId;
    private String firstName;
    private String secondName;
    private String surname;
    private String secondSurname;
    private String dni;
    private LocalDate birthDate;
    private String gender;
    private String civilStatus;
    private String phone;
    private String mail;
    private String city;
    private String department;
    private String country;
    private String address;
    private String profileImage;
    private String username;
    private String password;
    private Boolean statusUser;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String registeredBy;
    private String updatedBy;
    private Boolean registrationStatus;
}
