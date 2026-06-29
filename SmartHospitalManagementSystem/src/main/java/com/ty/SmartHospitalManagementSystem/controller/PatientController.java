package com.ty.SmartHospitalManagementSystem.controller;

import com.ty.SmartHospitalManagementSystem.dto.request.PatientRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.PatientResponseDTO;
import com.ty.SmartHospitalManagementSystem.exception.ResourceAlreadyExistsException;
import com.ty.SmartHospitalManagementSystem.service.PatientService;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<PatientResponseDTO>> registerPatient(@Valid @RequestBody PatientRequestDTO patient) throws ResourceAlreadyExistsException {
        return patientService.savePatient(patient);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<ResponseStructure<List<PatientResponseDTO>>> registerAllPatients(@Valid @RequestBody List<PatientRequestDTO> patients) throws ResourceAlreadyExistsException{
        return patientService.saveAllPatients(patients);
    }
    @GetMapping("/viewById/{id}")
    public ResponseEntity<ResponseStructure<PatientResponseDTO>> viewPatient(@PathVariable int id){
        return patientService.findById(id);
    }
    @GetMapping("/viewAll")
    public ResponseEntity<ResponseStructure<List<PatientResponseDTO>>> viewAllPatients(){
        return patientService.findAllPatients();
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<PatientResponseDTO>> updatePatient(@Valid @RequestBody PatientRequestDTO patient) throws ResourceAlreadyExistsException{
        return patientService.updatePatient(patient);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deletePatient(@PathVariable int id){
        return patientService.deletePatient(id);
    }
    @GetMapping("/viewByName/{name}")
    public ResponseEntity<ResponseStructure<List<PatientResponseDTO>>> viewPatientByName(@PathVariable String name){
        return patientService.findByName(name);
    }
}
