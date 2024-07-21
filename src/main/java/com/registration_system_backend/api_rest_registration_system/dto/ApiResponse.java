package com.registration_system_backend.api_rest_registration_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int codRespuesta;
    private String menRespuesta;
    private String desRespuesta;
    private T data;
}
