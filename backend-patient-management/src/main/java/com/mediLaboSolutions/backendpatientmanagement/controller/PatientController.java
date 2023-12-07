package com.mediLaboSolutions.backendpatientmanagement.controller;

import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.services.PatientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PatientController {
    final
    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/patients")
    public List<PatientDTO> patientsList() {

        return patientService.getAllPatients();
    }

    @GetMapping(value = "/patient")
    public PatientDTO patientInfos(@RequestParam String firstname, @RequestParam String lastname) {

        return patientService.getPatientByFirstAndLastName(firstname, lastname);
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        log.info("Ask to create patient : {} + {}", patientDTO.getFirstname(), patientDTO.getLastname());
        patientService.saveNewPatient(patientDTO);
        return new ResponseEntity<>(patientDTO, HttpStatus.CREATED);
    }

    @PutMapping("/patient")
    public ResponseEntity<PatientDTO> updatePatient(@Valid @RequestBody PatientDTO patientDTO) {
        log.info("Ask to update patient : {} + {}", patientDTO.getFirstname(), patientDTO.getLastname());
        patientService.updatePatient(patientDTO);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @DeleteMapping("/patient")
    public ResponseEntity<HttpStatus> deletePatient(@Valid @RequestBody PatientDTO patientDTO) {
        log.info("Ask to delete patient : {} + {}", patientDTO.getFirstname(), patientDTO.getLastname());
        patientService.deletePatient(patientDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
