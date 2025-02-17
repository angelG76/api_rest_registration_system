package com.registration_system_backend.api_rest_registration_system.repository;

import com.registration_system_backend.api_rest_registration_system.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
