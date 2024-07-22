package com.registration_system_backend.api_rest_registration_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sr_students")
public class StudentModel {
    @Id
    @Column(name = "student_id", length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID studentId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private PersonModel personModel;
}
