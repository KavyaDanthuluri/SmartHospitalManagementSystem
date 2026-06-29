package com.ty.SmartHospitalManagementSystem.controller;

import com.ty.SmartHospitalManagementSystem.dto.request.DoctorRequestDTO;
import com.ty.SmartHospitalManagementSystem.dto.response.DoctorResponseDTO;
import com.ty.SmartHospitalManagementSystem.exception.ResourceAlreadyExistsException;
import com.ty.SmartHospitalManagementSystem.service.DoctorService;
import com.ty.SmartHospitalManagementSystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    public DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<DoctorResponseDTO>> addDoctor(@Valid @RequestBody DoctorRequestDTO doctor) throws ResourceAlreadyExistsException {
        return doctorService.saveDoctor(doctor);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<ResponseStructure<List<DoctorResponseDTO>>> addAllDoctors(@Valid @RequestBody List<DoctorRequestDTO> doctors){
        return doctorService.saveAllDoctors(doctors);
    }
    @GetMapping("/viewById/{id}")
    public ResponseEntity<ResponseStructure<DoctorResponseDTO>> viewDoctor(@PathVariable int id){
        return doctorService.findDoctor(id);
    }
    @GetMapping("/viewAll")
    public ResponseEntity<ResponseStructure<List<DoctorResponseDTO>>> viewAllDoctors(){
        return doctorService.findAllDoctors();
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<DoctorResponseDTO>> updateDoctor(@Valid @RequestBody DoctorRequestDTO doctor){
        return doctorService.updateDoctor(doctor);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteDoctor(@PathVariable int id){
        return doctorService.deleteDoctor(id);
    }
    @GetMapping("/viewByEmail/{email}")
    public ResponseEntity<ResponseStructure<DoctorResponseDTO>> viewDoctorByEmail(@PathVariable String email){
        return doctorService.findByEmail(email);
    }
    @GetMapping("/viewByDepartment/{departmentName}")
    public ResponseEntity<ResponseStructure<List<DoctorResponseDTO>>> viewDoctorByDepartment(@PathVariable String departmentName){
        return doctorService.findDoctorByDepartment(departmentName);
    }


}
