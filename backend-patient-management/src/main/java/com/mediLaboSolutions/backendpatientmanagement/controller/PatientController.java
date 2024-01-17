package com.mediLaboSolutions.backendpatientmanagement.controller;

import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.services.PatientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PatientController {
    final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    /**
     * Handles HTTP GET request for retrieving a list of all patients.
     *
     * @return a list of PatientDTO representing all patients
     */
    @GetMapping(value = "/patients")
    public List<PatientDTO> patientsList() {
        log.info("Ask for list of all patients");
        return patientService.getAllPatients();
    }

    /**
     * Handles HTTP GET request for retrieving information about a specific patient.
     *
     * @param id the ID of the patient to retrieve
     * @return the PatientDTO representing the patient
     */
    @GetMapping(value = "/patients/{id}")
    public PatientDTO patientInfos(@PathVariable Integer id) {
        log.info("Ask to patient with id : {}", id);
        return patientService.getPatientById(id);
    }

    /**
     * Handles HTTP POST request for creating a new patient.
     *
     * @param newPatientDTO the NewPatientDTO containing information about the new patient
     * @return the created NewPatientDTO
     */
    @PostMapping("/patients")
    public NewPatientDTO createPatient(@Valid @RequestBody NewPatientDTO newPatientDTO) {
        log.info("Ask to create patient : {} + {}", newPatientDTO.getFirstname(), newPatientDTO.getLastname());
        patientService.saveNewPatient(newPatientDTO);
        return newPatientDTO;
    }

    /**
     * Handles HTTP PUT request for updating an existing patient.
     *
     * @param id                 the ID of the patient to update
     * @param patientToUpdateDTO the PatientDTO containing updated information about the patient
     * @return the updated PatientDTO
     */
    @PutMapping("/patients/{id}")
    public PatientDTO updatePatient(@PathVariable Integer id, @Valid @RequestBody PatientDTO patientToUpdateDTO) {
        log.info("Ask to update patient : {} + {}", patientToUpdateDTO.getFirstname(), patientToUpdateDTO.getLastname());
        patientToUpdateDTO.setPatientId(id);
        patientService.updatePatient(patientToUpdateDTO);
        return patientToUpdateDTO;
    }
}
