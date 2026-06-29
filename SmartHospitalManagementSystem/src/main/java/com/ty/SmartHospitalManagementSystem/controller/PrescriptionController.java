package com.ty.SmartHospitalManagementSystem.controller;

import com.ty.SmartHospitalManagementSystem.dto.request.PrescriptionRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.PrescriptionResponseDTO;
import com.ty.SmartHospitalManagementSystem.exception.ResourceAlreadyExistsException;
import com.ty.SmartHospitalManagementSystem.exception.ResourceNotFoundException;
import com.ty.SmartHospitalManagementSystem.service.PrescriptionService;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<PrescriptionResponseDTO>> addPrescription(@Valid @RequestBody PrescriptionRequestDTO prescription) throws ResourceNotFoundException, ResourceAlreadyExistsException {
        return prescriptionService.savePrescription(prescription);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<PrescriptionResponseDTO>> updatePrescription(@Valid @RequestBody PrescriptionRequestDTO prescription){
        return prescriptionService.updatePrescription(prescription);
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<ResponseStructure<PrescriptionResponseDTO>> viewPrescription(@PathVariable int id) throws ResourceNotFoundException {
        return prescriptionService.findPrescription(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deletePrescription(@PathVariable int id){
        return prescriptionService.deletePrescription(id);
    }
}
