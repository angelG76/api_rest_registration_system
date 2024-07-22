package com.registration_system_backend.api_rest_registration_system.repository;

import com.registration_system_backend.api_rest_registration_system.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
}
