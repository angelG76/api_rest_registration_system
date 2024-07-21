package com.registration_system_backend.api_rest_registration_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private UUID studentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID personId;
}
