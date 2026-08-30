package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients () {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(p -> PatientMapper.toDTO(p)).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient = patientRepository.save(PatientMapper.toEntity(patientRequestDTO));
         return PatientMapper.toDTO(patient);
    }

    public PatientResponseDTO getPatient(UUID patientId) {
        return patientRepository.findById(patientId).map(PatientMapper::toDTO).orElse(null);
    }
}
