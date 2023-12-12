package com.mediLaboSolutions.backendpatientmanagement.controller;

import com.mediLaboSolutions.backendpatientmanagement.DTO.NewPatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientDTO;
import com.mediLaboSolutions.backendpatientmanagement.DTO.PatientToUpdateDTO;
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

    @GetMapping(value = "/patients")
    public List<PatientDTO> patientsList() {
        log.info("Ask for list of all patients");
        return patientService.getAllPatients();
    }

    @GetMapping(value = "/patients/{id}")
    public PatientDTO patientInfos(@PathVariable Integer id) {
        log.info("Ask to patient with id : {}", id);
        return patientService.getPatientById(id);
    }

    @PostMapping("/patients")
    public NewPatientDTO createPatient(@Valid @RequestBody NewPatientDTO newPatientDTO) {
        log.info("Ask to create patient : {} + {}", newPatientDTO.getFirstname(), newPatientDTO.getLastname());
        patientService.saveNewPatient(newPatientDTO);
        return newPatientDTO;
    }

    @PutMapping("/patients/{id}")
    public PatientToUpdateDTO updatePatient(@PathVariable Integer id, @Valid @RequestBody PatientToUpdateDTO patientToUpdateDTO) {
        log.info("Ask to update patient : {} + {}", patientToUpdateDTO.getFirstname(), patientToUpdateDTO.getLastname());
        patientToUpdateDTO.setPatientId(id);
        patientService.updatePatient(patientToUpdateDTO);
        return patientToUpdateDTO;
    }


}
