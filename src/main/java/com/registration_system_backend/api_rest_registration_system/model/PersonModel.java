package com.registration_system_backend.api_rest_registration_system.model;

import com.registration_system_backend.api_rest_registration_system.enums.CivilStatus;
import com.registration_system_backend.api_rest_registration_system.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sr_persons")
public class PersonModel {

    @Id
    @Column(name = "person_id", length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID personId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "second_name", length = 50)
    private String secondName;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "second_surname", length = 50)
    private String secondSurname;

    @Column(name = "dni", length = 50, unique = true)
    private String dni;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "civil_status")
    private CivilStatus civilStatus;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "mail", length = 100, unique = true)
    private String mail;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "country", length = 30)
    private String country;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "status_user")
    private boolean statusUser;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "registered_by", length = 50)
    private String registeredBy;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "registration_status")
    private boolean registrationStatus;

    @OneToOne(mappedBy = "personModel")
    private StudentModel studentModel;
}
