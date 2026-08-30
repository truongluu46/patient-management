package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
    @NotBlank
    @Size(max = 100, message = "Name can not exceed 100 characters")
    private String name;

    @NotBlank
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String dateOfBirth;

    @NotNull
    private String registeredDate;


}
